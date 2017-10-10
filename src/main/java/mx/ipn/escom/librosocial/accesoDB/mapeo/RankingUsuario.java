/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.mapeo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Usuario usuarioRankeado;
    
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idUsuarioRankea",referencedColumnName = "idUsuario",insertable = false,updatable = false)
    private List<Usuario> usuariosRankea;

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

    public Usuario getUsuarioRankeado() {
        return usuarioRankeado;
    }

    public void setUsuarioRankeado(Usuario usuarioRankeado) {
        this.usuarioRankeado = usuarioRankeado;
    }

    public List<Usuario> getUsuariosRankea() {
        return usuariosRankea;
    }

    public void setUsuariosRankea(List<Usuario> usuariosRankea) {
        this.usuariosRankea = usuariosRankea;
    }
}
