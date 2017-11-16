package mx.ipn.escom.socialwriters.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notificacion")
public class Notificacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idNotificacion")
	private Integer id;
	
	@Column(name = "tipo")
	private Integer tipo;
	
	@Column(name = "laida")
	private Integer leida;
	
	@Column(name = "idUsuario")
	private Integer idUsuario;
	
	@Column(name = "idObra")
	private Integer idObra;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
	private Usuario usuarioObj;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "idObra", referencedColumnName = "idObra", insertable = false, updatable = false)
	private Obra obraObj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getLeida() {
		return leida;
	}

	public void setLeida(Integer leida) {
		this.leida = leida;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdObra() {
		return idObra;
	}

	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}

	public Usuario getUsuarioObj() {
		return usuarioObj;
	}

	public void setUsuarioObj(Usuario usuarioObj) {
		this.usuarioObj = usuarioObj;
	}

	public Obra getObraObj() {
		return obraObj;
	}

	public void setObraObj(Obra obraObj) {
		this.obraObj = obraObj;
	}
}
