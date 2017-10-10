/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author josemiguel
 */
@Entity
@Table(name = "redesSociales")
public class RedesSociales {
    @Id
    @Column(name = "idRedSocial")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;

    public Integer getIdRedSocial() {
        return id;
    }

    public void setIdRedSocial(Integer idRedSocial) {
        this.id = idRedSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
