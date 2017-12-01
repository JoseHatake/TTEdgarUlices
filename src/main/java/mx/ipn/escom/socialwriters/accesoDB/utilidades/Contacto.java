package mx.ipn.escom.socialwriters.accesoDB.utilidades;

public class Contacto {
	private String nickName;
	private String imgPerfil;
	private Integer estrellas;
	
	public Contacto() {
		super();
		nickName = null;
		imgPerfil = null;
		estrellas = null;
	}

	public Contacto(String nickName, String imgPerfil, Integer estrellas) {
		super();
		this.nickName = nickName;
		this.imgPerfil = imgPerfil;
		this.estrellas = estrellas;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getImgPerfil() {
		return imgPerfil;
	}

	public void setImgPerfil(String imgPerfil) {
		this.imgPerfil = imgPerfil;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}
}
