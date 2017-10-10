/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.AtiendeDenuncia;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("atiendeDenunciaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AtiendeDenunciaDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public AtiendeDenuncia guardar(AtiendeDenuncia atiendeDenuncia){
        sessionFactory.getCurrentSession().save(atiendeDenuncia);
        return atiendeDenuncia;
    }
    
    public AtiendeDenuncia actualizar(AtiendeDenuncia atiendeDenuncia){
        sessionFactory.getCurrentSession().merge(atiendeDenuncia);
        sessionFactory.getCurrentSession().update(atiendeDenuncia);
        return atiendeDenuncia;
    }
    
    public void eliminar(AtiendeDenuncia atiendeDenuncia){
        sessionFactory.getCurrentSession().delete(atiendeDenuncia);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public AtiendeDenuncia buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(AtiendeDenuncia.class, id);
    }
}
