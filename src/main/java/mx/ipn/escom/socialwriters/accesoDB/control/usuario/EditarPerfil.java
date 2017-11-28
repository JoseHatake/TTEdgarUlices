package mx.ipn.escom.socialwriters.accesoDB.control.usuario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.FormaContactoBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.PaisesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.PerfilBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.RedesSocialesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.FormaContacto;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Perfil;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.RedesSociales;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;
import mx.ipn.escom.socialwriters.accesoDB.utilidades.Fechas;

/**
 * Servlet implementation class EditarPerfil
 */
@WebServlet("/EditarPerfil")
@MultipartConfig
public class EditarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PaisesBs paisesBs;
	
	@Autowired
	private PerfilBs perfilBs;
	
	@Autowired
	private UsuarioBs usuarioBs;
	
	@Autowired
	private FormaContactoBs formaContactoBs;
	
	@Autowired
	private RedesSocialesBs redesSocialesBs;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<FileItem> partes = new ArrayList<>();
		Usuario usuarioObj;
		Perfil perfilObj = new Perfil();
		List<FormaContacto> formaContactos;
		List<RedesSociales> redesSociales;
		FormaContacto aux;
		Fechas fecha = new Fechas();
		String usuario,nombre,aPaterno,aMaterno,correo,fechaNacimiento,sexo,descripcion,urlRedSocial;
		Integer pais,contRedes;
		Boolean flag;
		
		usuarioObj = (Usuario) session.getAttribute("usuario");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5120);
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        try {
            FileItem item;
            File file;
            String contexto;
            
            contexto = this.getServletConfig().getServletContext().getRealPath("/");
            
			partes = upload.parseRequest(request);
			item = partes.get(0);
			file = new File(contexto + "/img", usuarioObj.getNick() + ".png");
            item.write(file);
            
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		usuario = partes.get(1).getString();
		nombre = partes.get(2).getString();
		aPaterno = partes.get(3).getString();
		aMaterno = partes.get(4).getString();
		correo = partes.get(5).getString();
		pais = Integer.parseInt(partes.get(6).getString());
		fechaNacimiento = partes.get(7).getString();
		sexo = partes.get(8).getString();
		descripcion = partes.get(partes.size()-1).getString();
		
		perfilObj = usuarioObj.getPerfilObj();
		perfilObj.setDescripcion(descripcion);
		perfilObj = perfilBs.actualizar(perfilObj);
		
		usuarioObj.setNick(usuario);
		usuarioObj.setNombre(nombre);
		usuarioObj.setPaterno(aPaterno);
		usuarioObj.setMaterno(aMaterno);
		usuarioObj.setCorreo(correo);
		usuarioObj.setIdPais(pais);
		usuarioObj.setPaisObj(paisesBs.buscarPorId(pais));
		usuarioObj.setFechaNacimiento(fecha.parseDate(fechaNacimiento));
		usuarioObj.setSexo(sexo);
		usuarioObj.setIdPerfil(perfilObj.getId());
		usuarioObj.setPerfilObj(perfilObj);
		
		usuarioObj = usuarioBs.actualizar(usuarioObj);
		
		formaContactos = formaContactoBs.buscarFormasContactoPorIdUsuario(usuarioObj.getId());
		redesSociales = redesSocialesBs.todasLasRedes();
		
		contRedes = 9;
		for (RedesSociales redesSociales2 : redesSociales) {
			urlRedSocial = partes.get(contRedes++).getString();
			flag = true;
			for (FormaContacto formaContactos2 : formaContactos) {
				if (formaContactos2.getIdRedSocial().equals(redesSociales2.getId())) {
					if (!urlRedSocial.equals(new String())) {
						formaContactos2.setUrl(urlRedSocial);
						formaContactoBs.actualizar(formaContactos2);
					}
					else {
						formaContactoBs.eliminar(formaContactos2.getId());
					}
					flag = false;
				}
			}
			if (flag) {
				if (!urlRedSocial.equals(new String())) {
					aux = new FormaContacto();
					aux.setIdUsuario(usuarioObj.getId());
					aux.setIdRedSocial(redesSociales2.getId());
					aux.setRedSocialObj(redesSociales2);
					aux.setUrl(urlRedSocial);
					formaContactoBs.guardar(aux);
				}
			}
		}
		
		session.setAttribute("usuario", usuarioObj);
		response.sendRedirect("BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=" + usuarioObj.getNick());
	}
}
