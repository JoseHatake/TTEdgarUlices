/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.Persona;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("personaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PersonaDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Persona guardar(Persona persona){
        sessionFactory.getCurrentSession().save(persona);
        return persona;
    }
    
    public Persona actualizar(Persona persona){
        sessionFactory.getCurrentSession().merge(persona);
        sessionFactory.getCurrentSession().update(persona);
        return persona;
    }
    
    public void eliminar(Persona persona){
        sessionFactory.getCurrentSession().delete(persona);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Persona buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Persona.class, id);
    }
}
