package mx.ipn.escom.socialwriters.accesoDB.control.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.socialwriters.accesoDB.bs.AlertasBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.CapituloBs;
import mx.ipn.escom.socialwriters.accesoDB.bs.SeguirObraBs;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Alertas;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Capitulo;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Obra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.SeguirObra;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;
import mx.ipn.escom.socialwriters.accesoDB.utilidades.Archivos;
import mx.ipn.escom.socialwriters.accesoDB.utilidades.StringCodificador;




/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/CrearCapitulo")
public class CrearCapitulo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
			
	@Autowired
	private AlertasBs alertasBs;
	
	@Autowired
	private SeguirObraBs seguirObraBs;
	
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
    public CrearCapitulo() {
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
		guardaCapitulo(request,response);	
		response.sendRedirect("index.jsp");
		
	}
	
	private void guardaCapitulo(HttpServletRequest request, HttpServletResponse response) {
		
		Usuario usuario = new Usuario();		
		HttpSession session = request.getSession();
		Archivos manejoArchivos;
		Capitulo capitulo = new Capitulo();
		List<SeguirObra> seguidores = new ArrayList();
		Alertas alerta = new Alertas();
		
		
		String textoCapitulo, contexto, idCapitulo,rutaCapitulo,tituloCapitulo;
		Integer idLibro,numeroCapitulo;
		Boolean guardado;
		guardado = true;
		
		usuario = (Usuario)session.getAttribute("usuario");
		contexto = (String) session.getAttribute("contexto");
		manejoArchivos = new Archivos(contexto);
		
		numeroCapitulo=Integer.valueOf(request.getParameter("numeroCapitulo"));
		tituloCapitulo = request.getParameter("tituloCapitulo");
		idLibro=Integer.valueOf(request.getParameter("idLibro"));
		textoCapitulo=request.getParameter("capitulo");
		
		capitulo.setNumero(numeroCapitulo);
		capitulo.setNombre(tituloCapitulo);
		capitulo.setIdObra(idLibro);
		
		
		//Guardamos el capitulo
		
		capituloBs.guardar(capitulo);
		
		rutaCapitulo=usuario.getId()+"/"+capitulo.getIdObra()+"/"+capitulo.getId()+".txt";
		
		try{
			manejoArchivos.guardarCapitulo(rutaCapitulo, textoCapitulo);
		}catch(Exception e) {
			guardado=false;
			e.printStackTrace();			
		}
		
		//Si se creó, mandamos notificaciones
		if(guardado) {
			System.out.println(idLibro);
			seguidores = seguirObraBs.buscarPorIdObra(idLibro);
			if(!seguidores.isEmpty()) {
				
				Usuario usuarioVacio = new Usuario();
				Obra obraVacia = new Obra();
				
				for(int i=0; i<seguidores.size();i++) {
					
					SeguirObra seguirObra = new SeguirObra();
					seguirObra = seguidores.get(i);
					alerta.setIdObra(idLibro);
					alerta.setIdUsuario(seguirObra.getIdUsuario());
					alerta.setEstatus(false);
					alerta.setTipoAlerta(2);
					alerta.setUsuario(usuarioVacio);
					alerta.setObra(obraVacia);
					alertasBs.guardar(alerta);
					
				}
				
			}
			
		}
		
	}

}
