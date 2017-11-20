package mx.ipn.escom.socialwriters.accesoDB.utilidades;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.PaisesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Paises;

/**
 * Servlet implementation class BuscarBeneficiario
 */
public class BuscarInformacionFormularios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioBs usuarioBs;
	
	@Autowired
	private PaisesBs paisesBs;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarInformacionFormularios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @see buscar -> adquiere valores para obtener la busqueda deseada:
	 * 		1: BuscarUsuarioDisponible -> busca si existen coinsidencias con el nombre de usuario en la base de datos
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Integer buscar = Integer.valueOf((String) request.getParameter("metodoDeBusqueda"));
		Boolean isAjax = Boolean.valueOf((String) request.getParameter("esAjax"));
		String direccion = request.getParameter("direccion");
		switch (buscar) {
			case 1:
				buscarUsuarioDisponible(request, response, out);
				break;
			case 2:
				buscarCorreoDisponible(request, response, out);
				break;
			case 3:
				enriquecerNuevoUsuario(request, response);
				break;
			case 4:
				enriquecerPerfilUsuario(request, response);
				break;
			default:
				rd = request.getRequestDispatcher("index.jsp");
				break;
		}
		if (isAjax){
			out.flush();
			out.close();
		}
		else {
			rd = request.getRequestDispatcher(direccion);
			rd.forward(request, response);
		}
	}

	private void enriquecerPerfilUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void enriquecerNuevoUsuario(HttpServletRequest request, HttpServletResponse response) {
		List<Paises> paises = paisesBs.listaPaises();
		List<Integer> anios = new ArrayList<Integer>();
		Integer x,anioActual;
		Fechas fechas = new Fechas();
		Date fechaActual = fechas.fechaActual("yyyy");
		String []fechaSeparada = fechaActual.toString().split(" ");
		anioActual = Integer.parseInt(fechaSeparada[fechaSeparada.length-1]);
		
		for (x = anioActual; x >= 1950;x--) {
			anios.add(x);
		}
		
		request.setAttribute("paises", paises);
		request.setAttribute("anios", anios);
	}

	private void buscarCorreoDisponible(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		String informacion = new String();
		String correo;
		
		correo = request.getParameter("correo");
		informacion = usuarioBs.validaCorreo(correo).toString();
		
		out.print(informacion);
	}

	private void buscarUsuarioDisponible(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws ServletException, IOException {
		String informacion = new String();
		String nombreUsuario;
		
		nombreUsuario = request.getParameter("usuario");
		informacion = usuarioBs.validaNick(nombreUsuario).toString();
		
		out.print(informacion);
	}
}
