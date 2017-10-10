/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.EstadoDenuncia;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("estadoDenunciaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class EstadoDenunciaDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public EstadoDenuncia guardar(EstadoDenuncia estadoDenuncia){
        sessionFactory.getCurrentSession().save(estadoDenuncia);
        return estadoDenuncia;
    }
    
    public EstadoDenuncia actualizar(EstadoDenuncia estadoDenuncia){
        sessionFactory.getCurrentSession().merge(estadoDenuncia);
        sessionFactory.getCurrentSession().update(estadoDenuncia);
        return estadoDenuncia;
    }
    
    public void eliminar(EstadoDenuncia estadoDenuncia){
        sessionFactory.getCurrentSession().delete(estadoDenuncia);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public EstadoDenuncia buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(EstadoDenuncia.class, id);
    }
}
