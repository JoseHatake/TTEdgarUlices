/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author josemiguel
 */
@Entity
@Table(name = "seguirUsuario")
public class SeguirUsuario {
    @Id
    @Column(name = "idSeguir")
    private Integer id;
    
    @Column(name = "idUsuarioSigue")
    private Integer idUsuarioSigue;
    
    @Column(name = "idUsuarioSeguido")
    private Integer idUsuarioSeguido;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idUsuarioSigue",referencedColumnName = "idUsuario",insertable = false,updatable = false)
    private Usuario usuarioSigueObj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuarioSigue() {
		return idUsuarioSigue;
	}

	public void setIdUsuarioSigue(Integer idUsuarioSigue) {
		this.idUsuarioSigue = idUsuarioSigue;
	}

	public Integer getIdUsuarioSeguido() {
		return idUsuarioSeguido;
	}

	public void setIdUsuarioSeguido(Integer idUsuarioSeguido) {
		this.idUsuarioSeguido = idUsuarioSeguido;
	}

	public Usuario getUsuarioSigueObj() {
		return usuarioSigueObj;
	}

	public void setUsuarioSigueObj(Usuario usuarioSigueObj) {
		this.usuarioSigueObj = usuarioSigueObj;
	}
}
