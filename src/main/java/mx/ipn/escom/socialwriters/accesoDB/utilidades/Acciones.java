package mx.ipn.escom.socialwriters.accesoDB.utilidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.PerfilBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.RankingUsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.SeguirUsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Perfil;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.SeguirUsuario;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class BuscarBeneficiario
 */
public class Acciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioBs usuarioBs;
	
	@Autowired
	private SeguirUsuarioBs seguirUsusarioBs;
	
	@Autowired
	private PerfilBs perfilBs;
	
	@Autowired
	private RankingUsuarioBs rankingUsuarioBs;

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
			case 4:
				recuperarClave(request, response);
				break;
			case 5:
				cambiarClave(request, response);
				break;
			case 6:
				direccion = seguirUsuario(request, response);
				break;
			default:
				direccion = "index.jsp";
				break;
		}
		rd = request.getRequestDispatcher(direccion);
		rd.forward(request, response);
	}

	private String seguirUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();
		List<SeguirUsuario> seguirUsuarios;
		SeguirUsuario tmp;
		Perfil perfilTmp;
		Usuario usuarioPerfil,usuarioSeguido;
		String seguido;
		Integer idUsuarioSeguido,contSeguidores;
		Boolean flag;
		
		seguido = request.getParameter("seguir");
		usuarioPerfil = (Usuario) sesion.getAttribute("usuario");
		usuarioSeguido = usuarioBs.buscarUsuarioPorNick(seguido);
		idUsuarioSeguido = usuarioSeguido.getId();
		
		seguirUsuarios = seguirUsusarioBs.buscarPorIdUsuario(usuarioPerfil.getId());
		flag = true;
		contSeguidores = 0;
		for (SeguirUsuario seguir: seguirUsuarios) {
			if (seguir.getIdUsuarioSeguido() == idUsuarioSeguido) {
				seguirUsusarioBs.eliminar(seguir);
				contSeguidores = -1;
				flag = false;
				break;
			}
		}
		if (flag) {
			tmp = new SeguirUsuario();
			tmp.setIdUsuarioSigue(usuarioPerfil.getId());
			tmp.setIdUsuarioSeguido(idUsuarioSeguido);
			tmp = seguirUsusarioBs.guardar(tmp);
			contSeguidores = 1;
		}
		perfilTmp = usuarioSeguido.getPerfilObj();
		contSeguidores += perfilTmp.getNumSeguidores();
		perfilTmp.setNumSeguidores(contSeguidores);
		perfilTmp = perfilBs.actualizar(perfilTmp);
		cargarContactos(request, response);
		return "BuscarInformacionFormularios?metodoDeBusqueda=4&esAjax=false&direccion=PerfilUsuario.jsp&nickName=" + usuarioSeguido.getNick();
	}

	private void cambiarClave(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario;
		HttpSession sesion = request.getSession();
		usuario = (Usuario)sesion.getAttribute("usuario");
		if(usuario.getClave()== Integer.parseInt(request.getParameter("claveActual"))) {
			usuario.setClave(Integer.parseInt(request.getParameter("claveNueva")));
			usuario = usuarioBs.actualizar(usuario);
			sesion.setAttribute("usuario", usuario);
			request.setAttribute("mensaje", 5);
		}else {
			request.setAttribute("mensaje", 6);
		}
	}

	private void recuperarClave(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario;
		String correo = request.getParameter("correo");
		if(!usuarioBs.validaCorreo(correo)) {
			GeneraClave clave = new GeneraClave();
			ObtenHash hash = new ObtenHash();
			String nclave = clave.generaPassword();
			int chash = hash.hash(nclave);
			usuario = usuarioBs.buscarUsuarioPorCorreo(correo);
			usuario.setClave(chash);
			usuarioBs.actualizar(usuario);
			
			Correo corclave = new Correo();
			MensajeCambiarClave mcc = new MensajeCambiarClave();
			
			String encabezadoClave, cuerpoClave;
			
			if(request.getLocale().getLanguage() == "es") {
				encabezadoClave= "Reestablecimiento de contraseña";
				cuerpoClave = mcc.creaEspañol(nclave);
				
			}else {
				encabezadoClave= "Password Restoration";
				cuerpoClave = mcc.creaIngles(nclave);
			}
			
			corclave.enviarCorreo(correo, encabezadoClave, cuerpoClave);
			request.setAttribute("mensaje", 3);
		}else {
			request.setAttribute("mensaje", 4);
		}
		
	}

	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("fotoPerfil");
		session.removeAttribute("usuario");
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Archivos archivos;
		Usuario usuario;
		String nick,contexto,fotoPerfil;
		Integer clave;
		
		contexto = this.getServletConfig().getServletContext().getRealPath("/");
		nick = request.getParameter("usuario");
		clave = Integer.parseInt(request.getParameter("clave"));
		
		usuario = usuarioBs.validaLogIn(nick, clave);
		archivos = new Archivos(contexto);
		fotoPerfil = null;
		if (archivos.exiteDocumento(nick, nick + ".png")) {
			fotoPerfil = archivos.obtenerImagenCodificada(nick, nick + ".png");
		}
		
		if (usuario.esNuevoUsuario()) {
			usuario.setNick(nick);
		}
		else if(usuario.getEstadoCuenta() == 0) {
			usuario = new Usuario();
			usuario.setNick(nick);
			usuario.setEstadoCuenta(0);
		}

		session.setAttribute("fotoPerfil", fotoPerfil);
		session.setAttribute("usuario", usuario);
		session.setAttribute("contexto", contexto);
		cargarContactos(request,response);
	}

	private void cargarContactos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Archivos archivo;
		Ranking ranking;
		Usuario usuario,usrTmp;
		List<Contacto> contactos;
		String contexto,imagenPerfil,nick;
		Integer contador,estrellas;
		List<SeguirUsuario> seguirUsuarios;
		
		usuario = (Usuario) session.getAttribute("usuario");
		contexto = (String) session.getAttribute("contexto");
		
		seguirUsuarios = seguirUsusarioBs.buscarPorIdUsuario(usuario.getId());
		archivo = new Archivos(contexto);
		contador = 0;
		contactos = new ArrayList<Contacto>();
		for (SeguirUsuario seguirUsuario : seguirUsuarios) {
			usrTmp = usuarioBs.buscarPorId(seguirUsuario.getIdUsuarioSeguido());
			nick = usrTmp.getNick();
			ranking = new Ranking(rankingUsuarioBs.buscarUsuariosRankea(usrTmp.getId()));
			estrellas = ranking.getEstrellas();
			imagenPerfil = null;
			if (archivo.exiteDocumento(nick, nick + ".png")) {
				imagenPerfil = archivo.obtenerImagenCodificada(nick, nick + ".png");
			}
			contactos.add(new Contacto(nick,imagenPerfil,estrellas));
			if (contador++ == 4)
				break;
		}
		session.setAttribute("contactos", contactos);
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
