/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.Genero;
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
    
    public Genero guardar(Genero generos){
        sessionFactory.getCurrentSession().save(generos);
        return generos;
    }
    
    public Genero actualizar(Genero generos){
        sessionFactory.getCurrentSession().merge(generos);
        sessionFactory.getCurrentSession().update(generos);
        return generos;
    }
    
    public void eliminar(Genero generos){
        sessionFactory.getCurrentSession().delete(generos);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Genero buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Genero.class, id);
    }
}
