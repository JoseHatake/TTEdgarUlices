/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.Perfil;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("perfilDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PerfilDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Perfil guardar(Perfil perfil){
        sessionFactory.getCurrentSession().save(perfil);
        return perfil;
    }
    
    public Perfil actualizar(Perfil perfil){
        sessionFactory.getCurrentSession().merge(perfil);
        sessionFactory.getCurrentSession().update(perfil);
        return perfil;
    }
    
    public void eliminar(Perfil perfil){
        sessionFactory.getCurrentSession().delete(perfil);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Perfil buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Perfil.class, id);
    }
}
