/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.SeguirUsuario;

import java.util.ArrayList;
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
@Service("seguirUsuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class SeguirUsuarioDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    protected String QUERY1 = "select a from SeguirUsuario a where idUsuarioSigue = ?1";
    protected String QUERY2 = "select a from SeguirUsuario a where idUsuarioSigue = ?1 and idUsuarioSeguido = ?2";
    
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
    
    public List<SeguirUsuario> buscarPorIdUsuario(Integer id) {
    		Query<SeguirUsuario> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,SeguirUsuario.class);
    		resultado.setParameter(1, id);
    		List<SeguirUsuario> sigue = resultado.list();
    		return sigue.isEmpty()?new ArrayList<SeguirUsuario>():sigue;
    }
    
    public Boolean verficarSeguirUsuario(Integer idUsuarioSigue, Integer idUsuarioSeguido) {
		Query<SeguirUsuario> resultado = sessionFactory.getCurrentSession().createQuery(QUERY2,SeguirUsuario.class);
		resultado.setParameter(1, idUsuarioSigue);
		resultado.setParameter(2, idUsuarioSeguido);
		List<SeguirUsuario> sigue = resultado.list();
		return !sigue.isEmpty();
    }
}
