/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.FormaContacto;

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
@Service("formaContactoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class FormaContactoDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    protected String QUERY1 = "select a from FormaContacto a where idUsuario = ?1";
    
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
    
    public List<FormaContacto> buscarFormasContactoPorIdUsuario(Integer idUsuario){
    		Query<FormaContacto> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,FormaContacto.class);
    		resultado.setParameter(1, idUsuario);
    		List<FormaContacto> formaContactos = resultado.list();
    		return formaContactos.isEmpty()?new ArrayList<FormaContacto>():formaContactos;
    }
}
