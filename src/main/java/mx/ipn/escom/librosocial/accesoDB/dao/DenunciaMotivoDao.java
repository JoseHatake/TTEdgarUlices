/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.dao;

import mx.ipn.escom.librosocial.accesoDB.mapeo.DenunciaMotivo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author josemiguel
 */
@Service("denunciaMotivoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class DenunciaMotivoDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    public DenunciaMotivo guardar(DenunciaMotivo denunciaMotivo){
        sessionFactory.getCurrentSession().save(denunciaMotivo);
        return denunciaMotivo;
    }
    
    public DenunciaMotivo actualizar(DenunciaMotivo denunciaMotivo){
        sessionFactory.getCurrentSession().merge(denunciaMotivo);
        sessionFactory.getCurrentSession().update(denunciaMotivo);
        return denunciaMotivo;
    }
    
    public void eliminar(DenunciaMotivo denunciaMotivo){
        sessionFactory.getCurrentSession().delete(denunciaMotivo);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public DenunciaMotivo buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(DenunciaMotivo.class, id);
    }
}
