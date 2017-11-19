package mx.ipn.escom.socialwriters.accesoDB.utilidades;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class BuscarBeneficiario
 */
public class Acciones extends HttpServlet {
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
	public Acciones() {
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
		Integer accion = Integer.valueOf((String) request.getParameter("accion"));
		String direccion = request.getParameter("direccion");
		switch (accion) {
			case 1:
				activarCuenta(request, response);
				break;
			case 2:
				iniciarSesion(request, response);
				break;
			case 3:
				cerrarSesion(request, response);
				break;
			default:
				direccion = "index.jsp";
				break;
		}
		rd = request.getRequestDispatcher(direccion);
		rd.forward(request, response);
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuario");
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Usuario usuario;
		String nick;
		Integer clave;
		
		nick = request.getParameter("usuario");
		clave = Integer.parseInt(request.getParameter("clave"));
		
		usuario = usuarioBs.validaLogIn(nick, clave);
		
		if (usuario.esNuevoUsuario()) {
			usuario.setNick(nick);
		}
		session.setAttribute("usuario", usuario);
	}

	private void activarCuenta(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario;
		String nick;
		Integer id;
		
		id = Integer.parseInt(request.getParameter("id"));
		nick = request.getParameter("nick");
		
		usuario = usuarioBs.buscarPorId(id);
		
		if (usuario.getNick().equals(nick)) {
			usuario.setEstadoCuenta(1);
			usuario = usuarioBs.actualizar(usuario);
			request.setAttribute("mensaje", 2);
			request.setAttribute("usuario", usuario);
		}
	}
}
