/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.GeneroObra;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("generoObraDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GeneroObraDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public GeneroObra guardar(GeneroObra generoObra){
        sessionFactory.getCurrentSession().save(generoObra);
        return generoObra;
    }
    
    public GeneroObra actualizar(GeneroObra generoObra){
        sessionFactory.getCurrentSession().merge(generoObra);
        sessionFactory.getCurrentSession().update(generoObra);
        return generoObra;
    }
    
    public void eliminar(GeneroObra generoObra){
        sessionFactory.getCurrentSession().delete(generoObra);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public GeneroObra buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(GeneroObra.class, id);
    }
}
