/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    
    protected String QUERY1 = "select a from Usuario a where nick = ?1";
    protected String QUERY2 = "select a from Usuario a where correo = ?1";
    
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
    
    public Boolean validaNick(String nickName) {
    		Query<Usuario> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,Usuario.class);
    		resultado.setParameter(1, nickName);
    		List<Usuario> identificados = resultado.list();
    		return identificados.isEmpty();
    }
    
    public Boolean validaCorreo(String correo) {
		Query<Usuario> resultado = sessionFactory.getCurrentSession().createQuery(QUERY2,Usuario.class);
		resultado.setParameter(1, correo);
		List<Usuario> identificados = resultado.list();
		return identificados.isEmpty();
}
}
