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

import mx.ipn.escom.socialwriters.accesoDB.bs.CapituloBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.FormaContactoBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.GeneroObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.ObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.PaisesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.RankingObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.RankingUsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.RedesSocialesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.SeguirObraBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.SeguirUsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Capitulo;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.FormaContacto;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.GeneroObra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Obra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Paises;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.RankingObra;
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
	private RankingObraBs rankingObraBs;
	
	@Autowired
	private PaisesBs paisesBs;
	
	@Autowired
	private FormaContactoBs formaContactoBs;
	
	@Autowired
	private RedesSocialesBs redesSocialesBs;
	
	@Autowired
	private SeguirUsuarioBs seguirUsuarioBs;
	
	@Autowired
	private SeguirObraBs seguirObraBs;
	
	@Autowired
	private ObraBs obraBs;
	
	@Autowired
	private GeneroObraBs generoObraBs;
	
	@Autowired
	private CapituloBs capituloBs;

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
				cambiarRankingUsuario(request, response);
				break;
			case 8:
				enriquecerPerfilObra(request, response);
				break;
			case 9:
				enriquecerLeerObra(request, response);
				break;
			case 10:
				cambiarRankingObraUsuario(request, response);
				break;
			case 11:
				cargaObrasDeUsuario(request,response);
				break;
			case 12:
				cargaObrasIndex(request,response);
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

	private void cargaObrasIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		List<Obra> obras;
		List<DetallesObra> detallesObras;
		String contexto;
		
		contexto = this.getServletConfig().getServletContext().getRealPath("/");
		
		obras = obraBs.todasLasObras();
		detallesObras = this.obtenerDetallesObraPorObras(obras,contexto);
		
		request.setAttribute("obras", detallesObras);
		session.setAttribute("contexto", contexto);
	}
	
	private DetallesObra obtenerDetalleObraPorObra(Obra obra,String contexto) throws IOException {
		DetallesObra detalles;
		Usuario usuario;
		Archivos archivo;
		Ranking ranking;
		String portada,nickName,titulo;
		Integer idUsuario,idObra,estrellas;
		
		usuario = obra.getUsuarioObj();
		idObra = obra.getId();
		idUsuario = usuario.getId();
		titulo = obra.getNombre();
		nickName = usuario.getNick();
		archivo = new Archivos(contexto);
		portada = null;
		if (archivo.exiteDocumento(idUsuario.toString() + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO)) {
			portada = archivo.obtenerImagenCodificada(idUsuario.toString() + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO);
		}
		ranking = new Ranking();
		estrellas = ranking.getEstrellasObra(rankingObraBs.buscarRankingPorIdObra(idObra));
		
		detalles = new DetallesObra(idObra, titulo, portada, nickName);
		detalles.setEstrellas(estrellas);
		return detalles;
	}
	
	private List<DetallesObra> obtenerDetallesObraPorObras(List<Obra> obras,String contexto) throws IOException{
		List<DetallesObra> detallesObras = new ArrayList<DetallesObra>();
		for (Obra obra:obras) {
			detallesObras.add(this.obtenerDetalleObraPorObra(obra,contexto));
		}
		return detallesObras;
	}

	private void cambiarRankingObraUsuario(HttpServletRequest request, HttpServletResponse response) {
		RankingObra ranking;
		Integer idUsuario,idObra,estrellas;
		
		idObra = Integer.parseInt(request.getParameter("idObra"));
		idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		estrellas = Integer.parseInt(request.getParameter("estrellas"));
		
		if (rankingObraBs.verificaRankeo(idObra, idUsuario)) {
			ranking = rankingObraBs.obtenerRankeo(idObra, idUsuario);
			if (ranking.getEstrellas() != estrellas) {
				ranking.setEstrellas(estrellas);
				ranking = rankingObraBs.actualizar(ranking);
			}
		}
		else {
			ranking = new RankingObra();
			ranking.setEstrellas(estrellas);
			ranking.setIdObra(idObra);;
			ranking.setIdUsuario(idUsuario);
			ranking = rankingObraBs.guardar(ranking);
		}
	}

	private void enriquecerLeerObra(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Obra obra;
		Usuario usuario;
		DetallesObra detallesObra;
		Integer idObra,idUsuario;
		String portada,nickName,contexto;
		Archivos archvio;
		
		contexto = (String) session.getAttribute("contexto");
		idObra = Integer.parseInt(request.getParameter("idObra"));
		obra = obraBs.buscarPorId(idObra);
		usuario = obra.getUsuarioObj();
		idUsuario = usuario.getId();
		nickName = usuario.getNick();
		portada = null;
		archvio = new Archivos(contexto);
		if (archvio.exiteDocumento(idUsuario + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO)) {
			portada = archvio.obtenerImagenCodificada(idUsuario + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO);
		}
		
		detallesObra = new DetallesObra(idObra, obra.getNombre(), portada, nickName);
		
		cargarCapitulo(request,response);
		request.setAttribute("detallesObra", detallesObra);
		request.setAttribute("obra", obra);
	}

	private void cargarCapitulo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<Capitulo> capitulos;
		Capitulo capituloTmp;
		Archivos archvio;
		Obra obra;
		String contexto;
		List<String> listaTextoCapitulo;
		Integer idUsuario,idObra,idCapitulo;
		
		contexto = (String) session.getAttribute("contexto");
		idObra = Integer.parseInt(request.getParameter("idObra"));
		idCapitulo = Integer.parseInt(request.getParameter("idCapitulo"));
		obra = obraBs.buscarPorId(idObra);
		idUsuario = obra.getUsuarioObj().getId();
		
		archvio = new Archivos(contexto);
		capitulos = capituloBs.buscarPorIdObra(idObra);
		if (!capitulos.isEmpty()) {
			if (idCapitulo == 0) {
				idCapitulo = capitulos.get(0).getId();
			}
			capituloTmp = capituloBs.buscarPorId(idCapitulo);
			for (Capitulo capitulo2 : capitulos) {
				if (capitulo2.getId() == idCapitulo) {
					capituloTmp = capitulo2;
					break;
				}
			}
			listaTextoCapitulo = archvio.cargaCapitulo(idUsuario + "/" + idObra + "/" + idCapitulo + ".txt");
		}
		else {
			listaTextoCapitulo = new ArrayList<String>();
			capituloTmp = new Capitulo();
			capituloTmp.setId(-1);
			capituloTmp.setIdObra(idObra);
			capituloTmp.setNombre(null);
			capituloTmp.setNumero(0);
		}
		
		request.setAttribute("capituloListaTexto", listaTextoCapitulo);
		request.setAttribute("capitulosObra", capitulos);
		request.setAttribute("capitulo", capituloTmp);
	}

	private void enriquecerPerfilObra(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		DetallesObra detallesObra;
		List<GeneroObra> generos;
		Obra obra;
		Usuario usuario;
		Integer idObra,idUsuario,estrellas;
		String titulo,portada,contexto,nickAutor;
		Archivos archivo;
		Ranking ranking;
		Boolean siguiendo;
		
		contexto = (String) session.getAttribute("contexto");
		usuario = (Usuario) session.getAttribute("usuario");
		idObra = Integer.parseInt(request.getParameter("idObra"));
		obra = obraBs.buscarPorId(idObra);
		archivo = new Archivos(contexto);
		
		idObra = obra.getId();
		titulo = obra.getNombre();
		idUsuario = obra.getIdUsuario();
		nickAutor = obra.getUsuarioObj().getNick();
		portada = null;
		if (archivo.exiteDocumento(idUsuario.toString() + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO)) {
			portada = archivo.obtenerImagenCodificada(idUsuario.toString() + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO);
		}
		detallesObra = new DetallesObra(idObra, titulo, portada, nickAutor);
		generos = generoObraBs.buscarPorIdObra(idObra);
		if (usuario != null) {
			siguiendo = seguirObraBs.verificarSeguirObra(idObra, usuario.getId());
		}else {
			siguiendo = null;
		}
		
		ranking = new Ranking();
		estrellas = ranking.getEstrellasObra(rankingObraBs.buscarRankingPorIdObra(idObra));
		
		request.setAttribute("detallesObra", detallesObra);
		request.setAttribute("obra", obra);
		request.setAttribute("generos", generos);
		request.setAttribute("siguiendo", siguiendo);
		request.setAttribute("estrellas", estrellas);
	}

	private void cambiarRankingUsuario(HttpServletRequest request, HttpServletResponse response) {
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
			ranking = new Ranking();
			estrellas = ranking.getEstrellasUsuario(rankingUsuarioBs.buscarUsuariosRankea(idUsuario));
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
		Ranking ranking;
		Usuario usuario;
		Contacto contacto;
		Archivos archivo;
		Integer idUsuario,estrellas;
		String nickName,contexto,imagenPerfil;
		Boolean siguiendo;
		
		usuario = (Usuario) session.getAttribute("usuario");
		contexto = (String) session.getAttribute("contexto");
		nickName = request.getParameter("nickName");
		siguiendo = false;
		contacto = new Contacto();
		archivo = new Archivos(contexto);
		
		if (usuario == null) {
			usuario = new Usuario();
			usuario.setNick("");
		}
		
		if (usuario.getNick().equals(nickName)) {
			idUsuario = usuario.getId();
		}
		else {
			imagenPerfil = null;
			usuario = usuarioBs.buscarUsuarioPorNick(nickName);
			idUsuario = usuario.getId();
			nickName = usuario.getNick();
			siguiendo = seguirUsuarioBs.verficarSeguirUsuario(idUsuario, usuario.getId());
			
			if (archivo.exiteDocumento(idUsuario.toString(), NOMBRE_FOTO_PERFIL)) {
				imagenPerfil = archivo.obtenerImagenCodificada(idUsuario.toString(),NOMBRE_FOTO_PERFIL);
			}
			contacto.setNickName(nickName);
			contacto.setImgPerfil(imagenPerfil);
		}
		request.setAttribute("idUsuario", idUsuario);
		cargaObrasDeUsuario(request,response);
		
		ranking = new Ranking();
		estrellas = ranking.getEstrellasUsuario(rankingUsuarioBs.buscarUsuariosRankea(idUsuario));
		
		formaContactos = formaContactoBs.buscarFormasContactoPorIdUsuario(idUsuario);
		request.setAttribute("contacto", contacto);
		request.setAttribute("siguiendo", siguiendo);
		request.setAttribute("redes", formaContactos);
		request.setAttribute("perfil", usuario);
		request.setAttribute("estrellas", estrellas);
	}

	private void cargaObrasDeUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		List<DetallesObra> detallesObras;
		List<Obra> obras;
		DetallesObra tmp;
		Ranking ranking;
		Archivos archivo;
		Usuario usuario;
		String titulo,portada,nickName,contexto;
		Integer idObra,idUsuario,estrellas;
		
		contexto = (String) session.getAttribute("contexto");
		idUsuario = (Integer)request.getAttribute("idUsuario");
		if (idUsuario == null) {
			idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		}
		obras = obraBs.obrasPorIdUsuario(idUsuario);
		usuario = usuarioBs.buscarPorId(idUsuario);
		detallesObras = new ArrayList<DetallesObra>();
		archivo = new Archivos(contexto);
		nickName = usuario.getNick();
		
		for (Obra obra: obras) {
			idObra = obra.getId();
			titulo = obra.getNombre();
			portada = null;
			if (archivo.exiteDocumento(idUsuario.toString() + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO)) {
				portada = archivo.obtenerImagenCodificada(idUsuario.toString() + "/" + idObra, NOMBRE_FOTO_PERFIL_LIBRO);
			}
			tmp = new DetallesObra(idObra, titulo, portada, nickName);
			ranking = new Ranking();
			estrellas = ranking.getEstrellasObra(rankingObraBs.buscarRankingPorIdObra(idObra));
			tmp.setEstrellas(estrellas);
			detallesObras.add(tmp);
		}
		request.setAttribute("obras", detallesObras);
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
