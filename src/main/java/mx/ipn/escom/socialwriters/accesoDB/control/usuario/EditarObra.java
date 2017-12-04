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
 * Servlet implementation class EditarObra
 */
@WebServlet("/EditarObra")
public class EditarObra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected String NOMBRE_FOTO_PERFIL_LIBRO = "fotoPerfilLibro.png";
	
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
    public EditarObra() {
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
		Obra obra = editarObra(request);
		response.sendRedirect("BuscarInformacionFormularios?metodoDeBusqueda=8&esAjax=false&direccion=PerfilObra.jsp&idObra=" + obra.getId());
	}

	private Obra editarObra(HttpServletRequest request)throws ServletException, IOException {
		List<GeneroObra> generosObra;
		Obra obra;	
		Genero genero = new Genero();
		Idioma idiomaObj = new Idioma();
		Alertas alerta = new Alertas();
		SeguirUsuario seguirUsuario=new SeguirUsuario();
		List<SeguirUsuario> seguidores = new ArrayList<SeguirUsuario>();
		Usuario usuario = new Usuario();		
		HttpSession session = request.getSession();
		List<FileItem> partes = new ArrayList<>();
		Integer size,numgeneros,idIdioma,idGenero,idUsuario,idObra,id;
		Boolean flag;
		Archivos manejoArchivos;
		StringCodificador codificador = new StringCodificador();
		String generoactual,contexto,titulo,sinopsis,idioma;
		
		usuario = (Usuario)session.getAttribute("usuario");
		contexto = (String) session.getAttribute("contexto");
		manejoArchivos = new Archivos(contexto);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5120);
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        flag = true;
		idUsuario = usuario.getId();
        try {
			partes = upload.parseRequest(request);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		
        titulo = codificador.codificar(partes.get(2).getString());
		obra = obraBs.buscarPorId(Integer.parseInt(partes.get(0).getString()));
		obra.setNombre(titulo);
		
		if(flag) {
			//Guardamos la obra
			
			size = partes.size();
			numgeneros = size-5;
			size = 3 + numgeneros;
			obra.setIdUsuario(usuario.getId());
			idioma = codificador.codificar(partes.get(3).getString());
			idIdioma = Integer.valueOf(idioma);
			sinopsis = codificador.codificar(partes.get(size+1).getString());
			idiomaObj = idiomaBs.buscarPorId(idIdioma);
			obra.setIdIdioma(idIdioma);
			obra.setSinopsis(sinopsis);
			obra.setUsuarioObj(usuario);
			obra.setIdiomaObj(idiomaObj);
			obra = obraBs.actualizar(obra);
			
			idObra = obra.getId();
			if (partes.get(1).getSize() != 0) {
				flag = manejoArchivos.guardarImagenEnArchivo(partes.get(1), idUsuario + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO);				
			}
			
			generosObra = generoObraBs.buscarPorIdObra(idObra);
			for (GeneroObra generoOb : generosObra) {
				generoObraBs.eliminar(generoOb);
			}
			
			//guardamos los géneros de la obra
			
			for(int i = 4; i<size+1;i++) {
				GeneroObra generoObra = new GeneroObra();				
				generoObra.setIdObra(obra.getId());
				generoObra.setObraObj(obra);
				generoactual = codificador.codificar(partes.get(i).getString());
				idGenero = Integer.valueOf(generoactual);
				genero = generoBs.buscarPorId(idGenero);
				generoObra.setGenerosObj(genero);
				generoObra.setIdGenero(idGenero);
				generoObraBs.guardar(generoObra);
			}
		}
		return obra;
	}
}
