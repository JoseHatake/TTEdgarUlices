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
@Table(name = "denuncia")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDenuncia")
    private Integer id;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "idEstadoDenuncia")
    private Integer idEstadoDenuncia;
    
    @Column(name = "idDenunciaMotivo")
    private Integer idDenunciaMotivo;
    
    @Column(name = "idUsuarioDenunciante")
    private Integer idUsuarioDenunciante;
    
    @Column(name = "idObra")
    private Integer idObra;
    
    @Column(name = "idPaises")
    private Integer idPais;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idEstadoDenuncia",referencedColumnName = "idEstadoDenuncia",insertable = false,updatable = false)
    private EstadoDenuncia estadoDenunciaObj;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idDenunciaMotivo",referencedColumnName = "idDenunciaMotivo",insertable = false,updatable = false)
    private DenunciaMotivo denunciaMotivoObj;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idUsuarioDenunciante",referencedColumnName = "idUsuario",insertable = false,updatable = false)
    private Usuario usuarioDenuncianteObj;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idObra",referencedColumnName = "idObra",insertable = false,updatable = false)
    private Obra obraObj;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idPais",referencedColumnName = "idPaises",insertable = false,updatable = false)
    private Paises paisObj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getIdEstadoDenuncia() {
        return idEstadoDenuncia;
    }

    public void setIdEstadoDenuncia(Integer idEstadoDenuncia) {
        this.idEstadoDenuncia = idEstadoDenuncia;
    }

    public Integer getIdDenunciaMotivo() {
        return idDenunciaMotivo;
    }

    public void setIdDenunciaMotivo(Integer idDenunciaMotivo) {
        this.idDenunciaMotivo = idDenunciaMotivo;
    }

    public Integer getIdUsuarioDenunciante() {
        return idUsuarioDenunciante;
    }

    public void setIdUsuarioDenunciante(Integer idUsuarioDenunciante) {
        this.idUsuarioDenunciante = idUsuarioDenunciante;
    }

    public Integer getIdObra() {
        return idObra;
    }

    public void setIdObra(Integer idObra) {
        this.idObra = idObra;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public EstadoDenuncia getEstadoDenunciaObj() {
        return estadoDenunciaObj;
    }

    public void setEstadoDenunciaObj(EstadoDenuncia estadoDenunciaObj) {
        this.estadoDenunciaObj = estadoDenunciaObj;
    }

    public DenunciaMotivo getDenunciaMotivoObj() {
        return denunciaMotivoObj;
    }

    public void setDenunciaMotivoObj(DenunciaMotivo denunciaMotivoObj) {
        this.denunciaMotivoObj = denunciaMotivoObj;
    }

    public Usuario getUsuarioDenuncianteObj() {
        return usuarioDenuncianteObj;
    }

    public void setUsuarioDenuncianteObj(Usuario usuarioDenuncianteObj) {
        this.usuarioDenuncianteObj = usuarioDenuncianteObj;
    }

    public Obra getObraObj() {
        return obraObj;
    }

    public void setObraObj(Obra obraObj) {
        this.obraObj = obraObj;
    }

    public Paises getPaisObj() {
        return paisObj;
    }

    public void setPaisObj(Paises paisObj) {
        this.paisObj = paisObj;
    }
}
