package mx.ipn.escom.socialwriters.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;

/**
 * Servlet Filter implementation class LogInActivo
 */
public class LogInActivo implements Filter {

    /**
     * Default constructor. 
     */
    public LogInActivo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * Si el rol del usuario es true, entonces es administrador
	 * Si el rol del usuario es false, entonces es usuario normal
	 * 
	 * perfil : es usado para indicar a la vista que menu cargar
	 * nombre : inidca a la vista el nombre del usuario y de no exisstir solo coloca el mensaje de "Iniciar sesión"
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestCast = (HttpServletRequest) request;
		HttpSession session = requestCast.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Integer perfil = 1;
		String nombre = "";
		
		if (usuario != null && !usuario.esNuevoUsuario()) {
			nombre = usuario.getNick();
			if (usuario.getPerfilObj().getRol() == 1)
				perfil = 2;
			else
				perfil = 3;
		}
		session.setAttribute("perfil", perfil);
		session.setAttribute("nombre", nombre);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filtro de sesiones inicializado...");
	}

}
