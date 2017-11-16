/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author josemiguel
 */
@Entity
@Table(name = "rankingUsuario")
public class RankingUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRanking")
    private Integer id;
    
    @Column(name = "estrellas")
    private Integer estrellas;
    
    @Column(name = "idUsuarioRankeado")
    private Integer idUsuarioRankeado;
    
    @Column(name = "idUsuarioRankea")
    private Integer idUsuarioRankea;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idUsuarioRankeado",referencedColumnName = "idUsuario",insertable = false,updatable = false)
    private Usuario usuarioRankeadoObj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public Integer getIdUsuarioRankeado() {
        return idUsuarioRankeado;
    }

    public void setIdUsuarioRankeado(Integer idUsuarioRankeado) {
        this.idUsuarioRankeado = idUsuarioRankeado;
    }

    public Integer getIdUsuarioRankea() {
        return idUsuarioRankea;
    }

    public void setIdUsuarioRankea(Integer idUsuarioRankea) {
        this.idUsuarioRankea = idUsuarioRankea;
    }

	public Usuario getUsuarioRankeadoObj() {
		return usuarioRankeadoObj;
	}

	public void setUsuarioRankeadoObj(Usuario usuarioRankeadoObj) {
		this.usuarioRankeadoObj = usuarioRankeadoObj;
	}
}
