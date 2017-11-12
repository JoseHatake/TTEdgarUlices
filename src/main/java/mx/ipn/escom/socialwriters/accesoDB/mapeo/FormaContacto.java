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
@Table(name = "formaContacto")
public class FormaContacto {
    @Id
    @Column(name = "idContacto")
    private Integer id;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "idRedSocial")
    private Integer idRedSocial;
    
    @Column(name = "idUsuario")
    private Integer idUsuario;
    
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario",insertable = false,updatable = false)
    private Usuario usuariosObj;
    
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idRedSocial",referencedColumnName = "idRedSocial",insertable = false,updatable = false)
    private RedesSociales redesSociales;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdRedSocial() {
        return idRedSocial;
    }

    public void setIdRedSocial(Integer idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuariosObj() {
        return usuariosObj;
    }

    public void setUsuariosObj(Usuario usuariosObj) {
        this.usuariosObj = usuariosObj;
    }

    public RedesSociales getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(RedesSociales redesSociales) {
        this.redesSociales = redesSociales;
    }
}
