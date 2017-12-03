/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.SeguirObra;

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
@Service("seguirObraDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class SeguirObraDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    protected String QUERY1 = "select a from SeguirObra a where idObra = ?1 and idUsuario = ?2";
    
    public SeguirObra guardar(SeguirObra seguirObra){
        sessionFactory.getCurrentSession().save(seguirObra);
        return seguirObra;
    }
    
    public SeguirObra actualizar(SeguirObra seguirObra){
        sessionFactory.getCurrentSession().merge(seguirObra);
        sessionFactory.getCurrentSession().update(seguirObra);
        return seguirObra;
    }
    
    public void eliminar(SeguirObra seguirObra){
        sessionFactory.getCurrentSession().delete(seguirObra);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public SeguirObra buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(SeguirObra.class, id);
    }
    
    public Boolean verificarSeguirObra(Integer idObra,Integer idUsuario) {
    		Query<SeguirObra> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,SeguirObra.class);
    		resultado.setParameter(1, idObra);
    		resultado.setParameter(2, idUsuario);
    		List<SeguirObra> siguiendo = resultado.list();
    		return !siguiendo.isEmpty();
    }
    
    public SeguirObra buscarPorObraUsuario(Integer idObra,Integer idUsuario) {
    		Query<SeguirObra> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,SeguirObra.class);
		resultado.setParameter(1, idObra);
		resultado.setParameter(2, idUsuario);
		List<SeguirObra> siguiendo = resultado.list();
		return siguiendo.get(0);
    }
}
