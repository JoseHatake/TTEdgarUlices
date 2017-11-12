/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.SeguirUsuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("seguirUsuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class SeguirUsuarioDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public SeguirUsuario guardar(SeguirUsuario seguirUsuario){
        sessionFactory.getCurrentSession().save(seguirUsuario);
        return seguirUsuario;
    }
    
    public SeguirUsuario actualizar(SeguirUsuario seguirUsuario){
        sessionFactory.getCurrentSession().merge(seguirUsuario);
        sessionFactory.getCurrentSession().update(seguirUsuario);
        return seguirUsuario;
    }
    
    public void eliminar(SeguirUsuario seguirUsuario){
        sessionFactory.getCurrentSession().delete(seguirUsuario);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public SeguirUsuario buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(SeguirUsuario.class, id);
    }
}
