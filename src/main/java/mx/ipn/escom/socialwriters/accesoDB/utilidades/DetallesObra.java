package mx.ipn.escom.socialwriters.accesoDB.utilidades;

public class DetallesObra {
	private Integer idObra;
	private String titulo;
	private String portada;
	private String nickAutor;
	private Integer estrellas;
	
	public DetallesObra() {
		super();
		idObra = null;
		titulo = null;
		portada = null;
		nickAutor = null;
		estrellas = null;
	}

	public DetallesObra(Integer idObra, String titulo, String portada, String nickAutor) {
		super();
		this.idObra = idObra;
		this.titulo = titulo;
		this.portada = portada;
		this.nickAutor = nickAutor;
	}

	public Integer getIdObra() {
		return idObra;
	}

	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public String getNickAutor() {
		return nickAutor;
	}

	public void setNickAutor(String nickAutor) {
		this.nickAutor = nickAutor;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}
}
