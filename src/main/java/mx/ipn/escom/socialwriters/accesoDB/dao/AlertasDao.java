/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.Alertas;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("alertasDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AlertasDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Alertas guardar(Alertas alertas){
        sessionFactory.getCurrentSession().save(alertas);
        return alertas;
    }
    
    public Alertas actualizar(Alertas alertas){
        sessionFactory.getCurrentSession().merge(alertas);
        sessionFactory.getCurrentSession().update(alertas);
        return alertas;
    }
    
    public void eliminar(Alertas alertas){
        sessionFactory.getCurrentSession().delete(alertas);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Alertas buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Alertas.class, id);
    }
}
