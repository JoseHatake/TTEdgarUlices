/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.mapeo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author josemiguel
 */
@Entity
@Table(name = "seguirObra")
public class SeguirObra {
    @Id
    @Column(name = "idSeguirObra")
    private Integer id;
    
    @Column(name = "idObra")
    private Integer idObra;
    
    @Column(name = "idUsuario")
    private Integer idUsuario;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idObra",referencedColumnName = "idObra",insertable = false,updatable = false)
    private List<Obra> obras;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario",insertable = false,updatable = false)
    private List<Usuario> usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdObra() {
        return idObra;
    }

    public void setIdObra(Integer idObra) {
        this.idObra = idObra;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
