package mx.ipn.escom.socialwriters.accesoDB.control.usuario;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.DenunciaBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.DenunciaMotivoBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.EstadoDenunciaBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.ObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.PaisesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.PersonaBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Denuncia;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.DenunciaMotivo;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Obra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;




/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/CrearCapitulo")
public class HacerDenuncia extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
			
	@Autowired
	private DenunciaBs denunciaBs;
	
	@Autowired
	private PersonaBs personaBs;
	
	@Autowired
	private ObraBs obraBs;
	
	@Autowired
	private DenunciaMotivoBs denunciaMotivoBs;
	
	@Autowired
	private PaisesBs paisesBs;
	
	@Autowired
	private EstadoDenunciaBs estadoDenunciaBs;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HacerDenuncia() {
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
		hazDenuncia(request,response);	
		response.sendRedirect("index.jsp");
		
	}
	
	private void hazDenuncia(HttpServletRequest request, HttpServletResponse response) {
		
        
		Usuario usuario = new Usuario();
		Obra obra = new Obra();	
		Denuncia denuncia = new Denuncia();
		DenunciaMotivo denunciaMotivo = new DenunciaMotivo();
		HttpSession session = request.getSession();
		
		String denunciaContenido;
		Integer idObra, idMotivo;
		
		usuario = (Usuario)session.getAttribute("usuario");
		
		
		idObra=Integer.valueOf(request.getParameter("idObra"));
		idMotivo = Integer.valueOf(request.getParameter("razon"));
		denunciaContenido = request.getParameter("descripcion");
		
		denuncia.setIdEstadoDenuncia(1);
		denuncia.setIdObra(idObra);
		denuncia.setIdDenunciaMotivo(idMotivo);
		denuncia.setIdUsuarioDenunciante(usuario.getId());
		denuncia.setIdPais(usuario.getIdPais());
		denuncia.setDescripcion(denunciaContenido);
		denuncia.setUsuarioDenuncianteObj(usuario);
		denuncia.setDenunciaMotivoObj(denunciaMotivoBs.buscarPorId(idMotivo));
		denuncia.setPaisObj(paisesBs.buscarPorId(usuario.getIdPais()));
		denuncia.setObraObj(obraBs.buscarPorId(idObra));
		denuncia.setEstadoDenunciaObj(estadoDenunciaBs.buscarPorId(1));
		
		denunciaBs.guardar(denuncia);
	}

}
