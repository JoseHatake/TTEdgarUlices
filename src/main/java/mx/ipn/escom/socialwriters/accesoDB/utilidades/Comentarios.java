package mx.ipn.escom.socialwriters.accesoDB.utilidades;

public class Comentarios {
	private Contacto contacto;
	private String comentario;
	private String fecha;
	
	public Comentarios() {
		super();
		contacto = null;
		comentario = null;
		fecha = null;
	}

	public Comentarios(Contacto contacto, String comentario, String fecha) {
		super();
		this.contacto = contacto;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
