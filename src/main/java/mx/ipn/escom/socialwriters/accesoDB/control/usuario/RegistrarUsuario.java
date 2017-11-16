package mx.ipn.escom.socialwriters.accesoDB.control.usuario;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.PaisesBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.PerfilBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Perfil;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;
import mx.ipn.escom.socialwriters.accesoDB.utilidades.Correo;
import mx.ipn.escom.socialwriters.accesoDB.utilidades.Fechas;
import mx.ipn.escom.socialwriters.accesoDB.utilidades.MensajeVerificarCuenta;

/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PaisesBs paisBs;
	
	@Autowired
	private PerfilBs perfilBs;
	
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
    public RegistrarUsuario() {
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
		Usuario usuario;
		usuario = registrarUsuario(request);
		mandarCorreo(usuario,request);
		response.sendRedirect("MensajeUsuarioRegistrado.jsp");
	}

	private void mandarCorreo(Usuario usuario,HttpServletRequest request) {
		Correo correo = new Correo();
		MensajeVerificarCuenta mensaje = new MensajeVerificarCuenta();
		String cuerpo,url,asunto;
		
		url = "http://localhost:8080/SocialWriters/index.jsp";
		
		if (request.getLocale().getLanguage() == "es") {
			cuerpo = mensaje.creaEspañol(usuario.getNick(), url);
			asunto = "Verificación de correo electrónico";
		}
		else {
			cuerpo = mensaje.creaIngles(usuario.getNick(), url);
			asunto = "E-mail verification";
		}
		
		correo.enviarCorreo(usuario.getCorreo(), asunto, cuerpo);
	}

	private Usuario registrarUsuario(HttpServletRequest request) {
		Usuario usuarioObj = new Usuario();
		Perfil perfilObj = new Perfil();
		Fechas fecha = new Fechas();
		String usuario,nombre,aPaterno,aMaterno,correo,fechaNacimiento,sexo;
		Integer clave,pais;
		
		usuario = request.getParameter("usuario");
		nombre = request.getParameter("nombre");
		aPaterno = request.getParameter("apellidoPaterno");
		aMaterno = request.getParameter("apellidoMaterno");
		correo = request.getParameter("correo");
		clave = Integer.parseInt(request.getParameter("clave"));
		pais = Integer.parseInt(request.getParameter("pais"));
		fechaNacimiento = request.getParameter("anio");
		fechaNacimiento += "-" + request.getParameter("mes");
		fechaNacimiento += "-" + request.getParameter("dia");
		sexo = request.getParameter("sexo");
		clave = Integer.parseInt(request.getParameter("clave"));
		
		perfilObj.setDescripcion("");
		perfilObj.setNumSeguidores(0);
		perfilObj.setRol(false);
		
		perfilObj = perfilBs.guardar(perfilObj);
		
		usuarioObj.setNick(usuario);
		usuarioObj.setNombre(nombre);
		usuarioObj.setPaterno(aPaterno);
		usuarioObj.setMaterno(aMaterno);
		usuarioObj.setCorreo(correo);
		usuarioObj.setClave(clave);
		usuarioObj.setIdPais(pais);
		usuarioObj.setPaisObj(paisBs.buscarPorId(pais));
		usuarioObj.setFechaNacimiento(fecha.parseDate(fechaNacimiento));
		usuarioObj.setSexo(sexo);
		usuarioObj.setEstadoCuenta(0);
		usuarioObj.setIdPerfil(perfilObj.getId());
		
		return usuarioBs.guardar(usuarioObj);
	}

}
