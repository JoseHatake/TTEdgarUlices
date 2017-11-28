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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.GeneroBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.GeneroObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.IdiomaBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.ObraBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Genero;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.GeneroObra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Idioma;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Obra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;




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
		//registraGeneros(request,obra);
		response.sendRedirect("index.jsp");
		
	}
	
	private Obra registraObra(HttpServletRequest request) {
		
		Obra obra = new Obra();
		Usuario usuario;		
		
		HttpSession sesion = request.getSession();
		usuario = (Usuario)sesion.getAttribute("usuario");
		obra.setUsuarioObj(usuario);
		obra.setIdiomaObj(idiomaBs.buscarPorId(Integer.parseInt(request.getParameter("idioma"))));
		obra.setIdUsuario(usuario.getId());
		obra.setNombre(request.getParameter("titulo"));
		obra.setSinopsis(request.getParameter("sinopsis"));
		obra.setIdIdioma(Integer.parseInt(request.getParameter("idioma")));
		
		obra = obraBs.guardar(obra);
		
		GeneroObra generoObra = new GeneroObra();
		Genero genero = new Genero();
		List<Genero> generos=new ArrayList<Genero>(); ;
		generoObra.setObraObj(obra);
		generoObra.setIdObra(obra.getId());	
		//generoObra.setGenerosObj(generoBs.todosLosGeneros());
	
		for(int i = 1; i<12; i++) {
			String param = String.valueOf(i);
			if(request.getParameter(param) == null) {
				
				
			}else {
				/*
				generoObra.setIdGenero(i);
				generoObraBs.guardar(generoObra);*/
				genero = generoBs.buscarPorId(i);
				generos.add(genero);
				//System.out.println("estoy aqui");
				
		
			}
			
		}
		
		generoObra.setGenerosObj(generos);		
		generoObraBs.guardar(generoObra);
		return obra;
		
	}
	
	/*private void registraGeneros(HttpServletRequest request, Obra obra) {
		
		GeneroObra generoObra = new GeneroObra();
		Genero generos = new Genero();
		
		for(int i=1; i<12; i++) {
			String parameter = String.valueOf(i);
			if (request.getParameter(parameter) == null) {
				
			}else {
				generoObra.setObraObj(obra);
				generoObra.setGenerosObj(generoBs.buscarPorId(i));
				generoObra.setIdObra(obra.getId());
				generoObra.setIdGenero(i);
				generoObraBs.guardar(generoObra);
			}
			
		}
		
	}*/




}
