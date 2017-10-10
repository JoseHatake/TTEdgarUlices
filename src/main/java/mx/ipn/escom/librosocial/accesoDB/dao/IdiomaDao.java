/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.Idioma;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("idiomaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class IdiomaDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Idioma guardar(Idioma idioma){
        sessionFactory.getCurrentSession().save(idioma);
        return idioma;
    }
    
    public Idioma actualizar(Idioma idioma){
        sessionFactory.getCurrentSession().merge(idioma);
        sessionFactory.getCurrentSession().update(idioma);
        return idioma;
    }
    
    public void eliminar(Idioma idioma){
        sessionFactory.getCurrentSession().delete(idioma);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Idioma buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Idioma.class, id);
    }
}
