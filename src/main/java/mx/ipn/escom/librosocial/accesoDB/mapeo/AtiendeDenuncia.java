/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.mapeo;

import java.util.Date;
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
@Table(name = "atiendeDenuncia")
public class AtiendeDenuncia {
    @Id
    @Column(name = "idAtiendeDenuncia")
    private Integer id;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "idUduario")
    private Integer idUsuario;
    
    @Column(name = "idDenuncia")
    private Integer idDenuncia;
    
    @Column(name = "idEstadoDenuncia")
    private Integer idEstadoDenuncia;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario",insertable = false,updatable = false)
    private Usuario usuarioObj;
    
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "idDenuncia",referencedColumnName = "idDenuncia",insertable = false,updatable = false)
    private Denuncia denunciaObj;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idEstadoDenuncia",referencedColumnName = "idEstadoDenuncia",insertable = false,updatable = false)
    private EstadoDenuncia estadoDenunciaObj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Integer getIdEstadoDenuncia() {
        return idEstadoDenuncia;
    }

    public void setIdEstadoDenuncia(Integer idEstadoDenuncia) {
        this.idEstadoDenuncia = idEstadoDenuncia;
    }

    public Usuario getUsuarioObj() {
        return usuarioObj;
    }

    public void setUsuarioObj(Usuario usuarioObj) {
        this.usuarioObj = usuarioObj;
    }

    public Denuncia getDenunciaObj() {
        return denunciaObj;
    }

    public void setDenunciaObj(Denuncia denunciaObj) {
        this.denunciaObj = denunciaObj;
    }

    public EstadoDenuncia getEstadoDenunciaObj() {
        return estadoDenunciaObj;
    }

    public void setEstadoDenunciaObj(EstadoDenuncia estadoDenunciaObj) {
        this.estadoDenunciaObj = estadoDenunciaObj;
    }
}
