/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.FormaContacto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("formaContactoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class FormaContactoDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public FormaContacto guardar(FormaContacto formaContacto){
        sessionFactory.getCurrentSession().save(formaContacto);
        return formaContacto;
    }
    
    public FormaContacto actualizar(FormaContacto formaContacto){
        sessionFactory.getCurrentSession().merge(formaContacto);
        sessionFactory.getCurrentSession().update(formaContacto);
        return formaContacto;
    }
    
    public void eliminar(FormaContacto formaContacto){
        sessionFactory.getCurrentSession().delete(formaContacto);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public FormaContacto buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(FormaContacto.class, id);
    }
}
