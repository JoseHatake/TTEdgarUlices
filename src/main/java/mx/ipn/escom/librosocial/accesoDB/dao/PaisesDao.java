/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.Paises;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("paisesDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PaisesDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Paises guardar(Paises paises){
        sessionFactory.getCurrentSession().save(paises);
        return paises;
    }
    
    public Paises actualizar(Paises paises){
        sessionFactory.getCurrentSession().merge(paises);
        sessionFactory.getCurrentSession().update(paises);
        return paises;
    }
    
    public void eliminar(Paises paises){
        sessionFactory.getCurrentSession().delete(paises);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Paises buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Paises.class, id);
    }
}
