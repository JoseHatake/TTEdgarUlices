/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.mapeo;

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
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "idUsuario")
    private Integer id;
    
    @Column(name = "nick")
    private String nick;
    
    @Column(name = "clave")
    private Integer clave;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "idPerfil")
    private Integer idPerfil;
    
    @Column(name = "idPersona")
    private Integer idPersona;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idPerfil",referencedColumnName = "idPerfil",insertable = false,updatable = false)
    private Perfil perfilObj;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idPersona",referencedColumnName = "idPersona",insertable = false,updatable = false)
    private Persona personaObj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Perfil getPerfilObj() {
        return perfilObj;
    }

    public void setPerfilObj(Perfil perfilObj) {
        this.perfilObj = perfilObj;
    }

    public Persona getPersonaObj() {
        return personaObj;
    }

    public void setPersonaObj(Persona personaObj) {
        this.personaObj = personaObj;
    }
}
