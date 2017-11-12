/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.Obra;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("obraDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ObraDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Obra guardar(Obra obra){
        sessionFactory.getCurrentSession().save(obra);
        return obra;
    }
    
    public Obra actualizar(Obra obra){
        sessionFactory.getCurrentSession().merge(obra);
        sessionFactory.getCurrentSession().update(obra);
        return obra;
    }
    
    public void eliminar(Obra obra){
        sessionFactory.getCurrentSession().delete(obra);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Obra buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Obra.class, id);
    }
}
