/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author josemiguel
 */
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column(name = "idPerfil")
    private Integer id;
    
    @Column(name = "num_seguidores")
    private Integer numSeguidores;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "rol")
    private Boolean rol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumSeguidores() {
        return numSeguidores;
    }

    public void setNumSeguidores(Integer numSeguidores) {
        this.numSeguidores = numSeguidores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getRol() {
        return rol;
    }

    public void setRol(Boolean rol) {
        this.rol = rol;
    }
}
