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
@Table(name = "generoObra")
public class GeneroObra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGeneroObra")
    private Integer id;
    
    @Column(name = "idObra")
    private Integer idObra;
    
    @Column(name = "idGenero")
    private Integer idGenero;
    
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idObra",referencedColumnName = "idObra",insertable = false,updatable = false)
    private Obra obraObj;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGenero",referencedColumnName = "idGenero",insertable = false,updatable = false)
    private Genero generosObj;

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

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Obra getObraObj() {
        return obraObj;
    }

    public void setObraObj(Obra obraObj) {
        this.obraObj = obraObj;
    }

	public Genero getGenerosObj() {
		return generosObj;
	}

	public void setGenerosObj(Genero generosObj) {
		this.generosObj = generosObj;
	}
}
