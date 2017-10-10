/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.Denuncia;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("denunciaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class DenunciaDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public Denuncia guardar(Denuncia denuncia){
        sessionFactory.getCurrentSession().save(denuncia);
        return denuncia;
    }
    
    public Denuncia actualizar(Denuncia denuncia){
        sessionFactory.getCurrentSession().merge(denuncia);
        sessionFactory.getCurrentSession().update(denuncia);
        return denuncia;
    }
    
    public void eliminar(Denuncia denuncia){
        sessionFactory.getCurrentSession().delete(denuncia);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Denuncia buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Denuncia.class, id);
    }
}
