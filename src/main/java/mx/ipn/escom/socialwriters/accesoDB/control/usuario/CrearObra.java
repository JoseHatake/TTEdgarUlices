package mx.ipn.escom.socialwriters.accesoDB.control.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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

import mx.ipn.escom.socialwriters.accesoDB.bs.AlertasBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.GeneroBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.GeneroObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.IdiomaBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.ObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.SeguirUsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Alertas;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Genero;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.GeneroObra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Idioma;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Obra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.SeguirUsuario;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;
import mx.ipn.escom.socialwriters.accesoDB.utilidades.Archivos;
import mx.ipn.escom.socialwriters.accesoDB.utilidades.StringCodificador;




/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/CrearObra")
public class CrearObra extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ObraBs obraBs;
	
	@Autowired
	private GeneroObraBs generoObraBs;
	
	@Autowired
	private GeneroBs generoBs;
	
	@Autowired
	private IdiomaBs idiomaBs;
	
	@Autowired
	private AlertasBs alertasBs;
	
	@Autowired
	private SeguirUsuarioBs seguirUsuarioBs;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearObra() {
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
		Obra obra = registraObra(request);		
		response.sendRedirect("index.jsp");
		
	}
	
	private Obra registraObra(HttpServletRequest request)throws ServletException, IOException {
		
		Obra obra = new Obra();		
		Genero genero = new Genero();
		Idioma idiomaObj = new Idioma();
		Alertas alerta = new Alertas();
		SeguirUsuario seguirUsuario=new SeguirUsuario();
		List<SeguirUsuario> seguidores = new ArrayList();
		Usuario usuario = new Usuario();		
		HttpSession session = request.getSession();
		List<FileItem> partes = new ArrayList<>();
		Integer size,numgeneros,idIdioma,idGenero;
		Boolean flag;
		Archivos manejoArchivos;
		StringCodificador codificador = new StringCodificador();
		String generoactual,contexto,titulo,sinopsis,idioma,nick;
		
		usuario = (Usuario)session.getAttribute("usuario");
		contexto = (String) session.getAttribute("contexto");
		manejoArchivos = new Archivos(contexto);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5120);
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        flag=true;
		nick=usuario.getNick();
		
        try {
			partes = upload.parseRequest(request);
			titulo=codificador.codificar(partes.get(1).getString());
			obra.setNombre(titulo);
			if (partes.get(0).getSize() != 0) {
				flag = manejoArchivos.guardarImagenEnArchivo(partes.get(0), nick+"/"+titulo, titulo + ".png");				
			}else {
				manejoArchivos.crearArchivo(nick+"/"+titulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		
		if(flag) {
			//Guardamos la obra
			
			size=partes.size();
			numgeneros=size-4;
			size=2+numgeneros;
			obra.setIdUsuario(usuario.getId());
			idioma = codificador.codificar(partes.get(2).getString());
			idIdioma=Integer.valueOf(idioma);
			sinopsis = codificador.codificar(partes.get(size+1).getString());
			idiomaObj=idiomaBs.buscarPorId(idIdioma);
			obra.setIdIdioma(idIdioma);
			obra.setSinopsis(sinopsis);
			obra.setUsuarioObj(usuario);
			obra.setIdiomaObj(idiomaObj);
			obra = obraBs.guardar(obra);
			
			//guardamos los géneros de la obra			
			
			for(int i = 3; i<size+1;i++) {
				GeneroObra generoObra = new GeneroObra();				
				generoObra.setIdObra(obra.getId());
				generoObra.setObraObj(obra);
				generoObra.setId(null);
				generoactual=codificador.codificar(partes.get(i).getString());
				idGenero=Integer.valueOf(generoactual);
				genero=generoBs.buscarPorId(idGenero);
				generoObra.setGenerosObj(genero);
				generoObra.setIdGenero(idGenero);
				generoObraBs.guardar(generoObra);
				
			}
			
			//creamos las notificaciones.
			alerta.setIdObra(obra.getId());
			alerta.setEstatus(false);
			alerta.setObra(obra);
			alerta.setTipoAlerta(1);
			alerta.setUsuario(usuario);
			
			seguidores = seguirUsuarioBs.buscarPorIdUsuarioSeguido(usuario.getId());
			if(!seguidores.isEmpty()) {
				for(int i=0; i<seguidores.size();i++){
					seguirUsuario = seguidores.get(i);
					alerta.setIdUsuario(seguirUsuario.getIdUsuarioSigue());
					alertasBs.guardar(alerta);
				}
			}
			
			
		}
		
		
		
		
	
		return obra;
		
	}
	



}
