package mx.ipn.escom.socialwriters.accesoDB.utilidades;

public class Contacto {
	private String nickName;
	private String imgPerfil;
	
	public Contacto() {
		super();
		nickName = null;
		imgPerfil = null;
	}

	public Contacto(String nickName, String imgPerfil) {
		super();
		this.nickName = nickName;
		this.imgPerfil = imgPerfil;
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
}
