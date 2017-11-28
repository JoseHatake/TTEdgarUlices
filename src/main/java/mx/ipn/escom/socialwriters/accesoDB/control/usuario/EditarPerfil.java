package mx.ipn.escom.socialwriters.accesoDB.control.usuario;

import java.io.File;
import java.io.IOException;
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
import org.apache.commons.fileupload.FileUploadException;
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
		Usuario usuarioObj;
		Perfil perfilObj = new Perfil();
		List<FormaContacto> formaContactos;
		List<RedesSociales> redesSociales;
		FormaContacto aux;
		Fechas fecha = new Fechas();
		String usuario,nombre,aPaterno,aMaterno,correo,fechaNacimiento,sexo,descripcion,urlRedSocial;
		Integer pais;
		Boolean flag;
		
		usuarioObj = (Usuario) session.getAttribute("usuario");
		
		System.out.println(request.getParameter("pais"));
		
		usuario = request.getParameter("usuario");
		nombre = request.getParameter("nombre");
		aPaterno = request.getParameter("apellidoPaterno");
		aMaterno = request.getParameter("apellidoMaterno");
		correo = request.getParameter("correo");
//		pais = Integer.parseInt(request.getParameter("pais"));
		sexo = request.getParameter("sexo");
		fechaNacimiento = request.getParameter("fechaNacimiento");
		descripcion = request.getParameter("biografia");
		
		perfilObj = usuarioObj.getPerfilObj();
		perfilObj.setDescripcion(descripcion);
		perfilObj = perfilBs.actualizar(perfilObj);
		
		usuarioObj.setNick(usuario);
		usuarioObj.setNombre(nombre);
		usuarioObj.setPaterno(aPaterno);
		usuarioObj.setMaterno(aMaterno);
		usuarioObj.setCorreo(correo);
//		usuarioObj.setIdPais(pais);
//		usuarioObj.setPaisObj(paisesBs.buscarPorId(pais));
		usuarioObj.setFechaNacimiento(fecha.parseDate(fechaNacimiento));
		usuarioObj.setSexo(sexo);
		usuarioObj.setIdPerfil(perfilObj.getId());
		usuarioObj.setPerfilObj(perfilObj);
		
		usuarioObj = usuarioBs.actualizar(usuarioObj);
		
		formaContactos = formaContactoBs.buscarFormasContactoPorIdUsuario(usuarioObj.getId());
		redesSociales = redesSocialesBs.todasLasRedes();
		
		for (RedesSociales redesSociales2 : redesSociales) {
			urlRedSocial = request.getParameter(redesSociales2.getNombre());
			flag = true;
			for (FormaContacto formaContactos2 : formaContactos) {
				if (formaContactos2.getIdRedSocial().equals(redesSociales2.getId())) {
					if (urlRedSocial != "") {
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
				if (urlRedSocial != "") {
					aux = new FormaContacto();
					aux.setIdUsuario(usuarioObj.getId());
					aux.setIdRedSocial(redesSociales2.getId());
					aux.setRedSocialObj(redesSociales2);
					aux.setUrl(urlRedSocial);
					formaContactoBs.guardar(aux);
				}
			}
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5120);
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        
        try {
        		List<FileItem> partes;
            FileItem item;
            File file;
            String auxCompara,contexto;
            
            contexto = request.getContextPath();
            
			partes = upload.parseRequest(request);
			Integer i = 1;
			while(i < partes.size()){
				System.out.println("Si hay archvio");
				System.out.println(partes.get(0).getString());
                item = partes.get(i);
                auxCompara = item.getFieldName();
                if(item.getSize()!=0){
                		System.out.println("El archivo tiene tamaño");
                    file = new File(contexto,"archvio"+i+".png");
                    item.write(file);
                }
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("usuario", usuarioObj);
		response.sendRedirect("BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=" + usuarioObj.getNick());
	}

	private void guardaImagen(FileItem file) {
		System.out.println(file);
	}
}
