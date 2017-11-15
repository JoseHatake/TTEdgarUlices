package mx.ipn.escom.socialwriters.accesoDB.utilidades;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.UsuarioBs;

/**
 * Servlet implementation class BuscarBeneficiario
 */
public class BuscarInformacionFormularios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioBs usuarioBs;

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
		switch (buscar) {
			case 1:
				buscarUsuarioDisponible(request, response, out);
				break;
			case 2:
				buscarCorreoDisponible(request, response, out);
				break;
			case 3:
				//rd = cargarInformacionNuevoBeneficiario(request, response);
				break;
			default:
				rd = request.getRequestDispatcher("index.jsp");
				break;
		}
		if (isAjax){
			out.flush();
			out.close();
		}
		else
			rd.forward(request, response);
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
