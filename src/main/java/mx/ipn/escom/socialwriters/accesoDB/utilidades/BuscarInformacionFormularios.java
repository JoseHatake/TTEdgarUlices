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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.FormaContactoBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.ObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.PaisesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.RankingUsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.RedesSocialesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.SeguirUsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.FormaContacto;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Obra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Paises;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.RankingUsuario;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.RedesSociales;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.SeguirUsuario;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class BuscarBeneficiario
 */
public class BuscarInformacionFormularios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected String NOMBRE_FOTO_PERFIL = "fotoPerfil.png";
	protected String NOMBRE_FOTO_PERFIL_LIBRO = "fotoPerfilLibro.png";
	
	@Autowired
	private UsuarioBs usuarioBs;
	
	@Autowired
	private RankingUsuarioBs rankingUsuarioBs;
	
	@Autowired
	private PaisesBs paisesBs;
	
	@Autowired
	private FormaContactoBs formaContactoBs;
	
	@Autowired
	private RedesSocialesBs redesSocialesBs;
	
	@Autowired
	private SeguirUsuarioBs seguirUsuarioBs;
	
	@Autowired
	private ObraBs obraBs;

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
			case 5:
				enriquecerPerfilUsuarioEditable(request, response);
				break;
			case 6:
				enriquecerAutoresSeguidos(request, response);
				break;
			case 7:
				cambiarRanking(request, response);
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

	private void cambiarRanking(HttpServletRequest request, HttpServletResponse response) {
		RankingUsuario ranking;
		Usuario rankea,rankeado;
		String usuarioRankea,usuarioRankeado;
		Integer idUsuarioRankea,idUsuarioRankeado,estrellas;
		
		usuarioRankea = request.getParameter("usuarioRankea");
		usuarioRankeado = request.getParameter("usuarioRankeado");
		estrellas = Integer.parseInt(request.getParameter("estrellas"));
		
		rankea = usuarioBs.buscarUsuarioPorNick(usuarioRankea);
		rankeado = usuarioBs.buscarUsuarioPorNick(usuarioRankeado);
		
		idUsuarioRankea = rankea.getId();
		idUsuarioRankeado = rankeado.getId();
		
		if (rankingUsuarioBs.verificaRankeo(idUsuarioRankea, idUsuarioRankeado)) {
			ranking = rankingUsuarioBs.obtenerRankeo(idUsuarioRankea, idUsuarioRankeado);
			if (ranking.getEstrellas() != estrellas) {
				ranking.setEstrellas(estrellas);
				ranking = rankingUsuarioBs.actualizar(ranking);
			}
		}
		else {
			ranking = new RankingUsuario();
			ranking.setEstrellas(estrellas);
			ranking.setIdUsuarioRankea(idUsuarioRankea);
			ranking.setIdUsuarioRankeado(idUsuarioRankeado);
			ranking = rankingUsuarioBs.guardar(ranking);
		}
	}

	private void enriquecerAutoresSeguidos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		List<Contacto> contactos;
		List<SeguirUsuario> seguirUsuarios;
		Usuario usuario;
		Contacto contacto;
		Archivos archivo;
		Ranking ranking;
		String contexto,nick,imagenPerfil;
		Integer estrellas,idUsuario;
		
		usuario = (Usuario) session.getAttribute("usuario");
		contexto = (String) session.getAttribute("contexto");
		
		archivo = new Archivos(contexto);
		contactos = new ArrayList<Contacto>();
		seguirUsuarios = seguirUsuarioBs.buscarPorIdUsuario(usuario.getId());
		
		for (SeguirUsuario seguirUsuario : seguirUsuarios) {
			usuario = usuarioBs.buscarPorId(seguirUsuario.getIdUsuarioSeguido());
			nick = usuario.getNick();
			idUsuario = usuario.getId();
			ranking = new Ranking(rankingUsuarioBs.buscarUsuariosRankea(idUsuario));
			estrellas = ranking.getEstrellas();
			imagenPerfil = null;
			if (archivo.exiteDocumento(idUsuario.toString(), NOMBRE_FOTO_PERFIL)) {
				imagenPerfil = archivo.obtenerImagenCodificada(idUsuario.toString(),NOMBRE_FOTO_PERFIL);
			}
			contacto = new Contacto(nick, imagenPerfil,estrellas);
			contactos.add(contacto);
		}
		request.setAttribute("listaContactos", contactos);
	}

	private void enriquecerPerfilUsuarioEditable(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<RedesSociales> redesSociales = redesSocialesBs.todasLasRedes();
		request.setAttribute("catalogoRedes", redesSociales);
		enriquecerPerfilUsuario(request, response);
		enriquecerNuevoUsuario(request, response);
	}

	private void enriquecerPerfilUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		List<FormaContacto> formaContactos;
		List<Obra> obras;
		List<DetallesObra> detallesObras;
		Ranking ranking;
		Usuario usuario;
		Contacto contacto;
		Archivos archivo;
		Integer idUsuario,estrellas,idObra;
		String nickName,contexto,imagenPerfil,titulo,portada;
		Boolean siguiendo;
		
		usuario = (Usuario) session.getAttribute("usuario");
		contexto = (String) session.getAttribute("contexto");
		nickName = request.getParameter("nickName");
		idUsuario = usuario.getId();
		siguiendo = false;
		contacto = new Contacto();
		archivo = new Archivos(contexto);
		
		if (usuario.getNick().equals(nickName)) {
			idUsuario = usuario.getId();
		}
		else {
			imagenPerfil = null;
			usuario = usuarioBs.buscarUsuarioPorNick(nickName);
			if (seguirUsuarioBs.verficarSeguirUsuario(idUsuario, usuario.getId())) {
				siguiendo = true;
			}
			idUsuario = usuario.getId();
			nickName = usuario.getNick();
			if (archivo.exiteDocumento(idUsuario.toString(), NOMBRE_FOTO_PERFIL)) {
				imagenPerfil = archivo.obtenerImagenCodificada(idUsuario.toString(),NOMBRE_FOTO_PERFIL);
			}
			contacto.setNickName(nickName);
			contacto.setImgPerfil(imagenPerfil);
		}
		
		obras = obraBs.obrasPorIdUsuario(idUsuario);
		detallesObras = new ArrayList<DetallesObra>();
		for (Obra obra: obras) {
			idObra = obra.getId();
			titulo = obra.getNombre();
			portada = null;
			if (archivo.exiteDocumento(idUsuario.toString() + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO)) {
				portada = archivo.obtenerImagenCodificada(idUsuario.toString() + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO);
			}
			detallesObras.add(new DetallesObra(idObra, titulo, portada, nickName));
		}
		
		ranking = new Ranking(rankingUsuarioBs.buscarUsuariosRankea(idUsuario));
		estrellas = ranking.getEstrellas();
		
		formaContactos = formaContactoBs.buscarFormasContactoPorIdUsuario(idUsuario);
		request.setAttribute("obras", detallesObras);
		request.setAttribute("contacto", contacto);
		request.setAttribute("siguiendo", siguiendo);
		request.setAttribute("redes", formaContactos);
		request.setAttribute("perfil", usuario);
		request.setAttribute("estrellas", estrellas);
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
