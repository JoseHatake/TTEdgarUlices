package mx.ipn.escom.socialwriters.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requestCast = (HttpServletRequest) request;
		HttpServletResponse responseCast = (HttpServletResponse) response;
		HttpSession session = requestCast.getSession();
		Usuario usuario = (Usuario) session.getAttribute("login");
		
		if (usuario == null) {
			responseCast.sendRedirect("index.jsp");
		}
		else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filtro de sesiones inicializado...");
	}

}
