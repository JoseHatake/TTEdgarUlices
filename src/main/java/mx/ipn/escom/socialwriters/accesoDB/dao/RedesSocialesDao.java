/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.RedesSociales;

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
@Service("redesSocialesDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class RedesSocialesDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    protected String QUERI1 = "select a from RedesSociales a";
    
    public RedesSociales guardar(RedesSociales redesSociales){
        sessionFactory.getCurrentSession().save(redesSociales);
        return redesSociales;
    }
    
    public RedesSociales actualizar(RedesSociales redesSociales){
        sessionFactory.getCurrentSession().merge(redesSociales);
        sessionFactory.getCurrentSession().update(redesSociales);
        return redesSociales;
    }
    
    public void eliminar(RedesSociales redesSociales){
        sessionFactory.getCurrentSession().delete(redesSociales);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public RedesSociales buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(RedesSociales.class, id);
    }
    
    public List<RedesSociales> todasLasRedes(){
    		Query<RedesSociales> resultado = sessionFactory.getCurrentSession().createQuery(QUERI1,RedesSociales.class);
    		return resultado.list();
    }
}
