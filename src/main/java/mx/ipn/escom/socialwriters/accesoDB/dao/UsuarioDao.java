/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("usuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Usuario guardar(Usuario usuario){
        sessionFactory.getCurrentSession().save(usuario);
        return usuario;
    }
    
    public Usuario actualizar(Usuario usuario){
        sessionFactory.getCurrentSession().merge(usuario);
        sessionFactory.getCurrentSession().update(usuario);
        return usuario;
    }
    
    public void eliminar(Usuario usuario){
        sessionFactory.getCurrentSession().delete(usuario);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Usuario buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Usuario.class, id);
    }
}
