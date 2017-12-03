/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.GeneroObra;

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
@Service("generoObraDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GeneroObraDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    protected String QUERY1 = "select a from GeneroObra a where idObra = ?1";
    
    public GeneroObra guardar(GeneroObra generoObra){
        sessionFactory.getCurrentSession().save(generoObra);
        return generoObra;
    }
    
    public GeneroObra actualizar(GeneroObra generoObra){
        sessionFactory.getCurrentSession().merge(generoObra);
        sessionFactory.getCurrentSession().update(generoObra);
        return generoObra;
    }
    
    public void eliminar(GeneroObra generoObra){
        sessionFactory.getCurrentSession().delete(generoObra);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public GeneroObra buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(GeneroObra.class, id);
    }
    
    public List<GeneroObra> buscarPorIdObra(Integer idObra){
    		Query<GeneroObra> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,GeneroObra.class);
    		resultado.setParameter(1, idObra);
    		List<GeneroObra> generosObra = resultado.list();
    		return generosObra.isEmpty()?new ArrayList<GeneroObra>():generosObra;
    }
}
