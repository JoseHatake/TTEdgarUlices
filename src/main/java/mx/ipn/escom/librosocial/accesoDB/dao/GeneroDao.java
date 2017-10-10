/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.Generos;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("generoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GeneroDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Generos guardar(Generos generos){
        sessionFactory.getCurrentSession().save(generos);
        return generos;
    }
    
    public Generos actualizar(Generos generos){
        sessionFactory.getCurrentSession().merge(generos);
        sessionFactory.getCurrentSession().update(generos);
        return generos;
    }
    
    public void eliminar(Generos generos){
        sessionFactory.getCurrentSession().delete(generos);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Generos buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Generos.class, id);
    }
}
