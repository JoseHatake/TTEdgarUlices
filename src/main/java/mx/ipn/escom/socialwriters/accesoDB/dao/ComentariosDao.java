/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.Comentarios;

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
@Service("comentariosDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ComentariosDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    protected String QUERY1 = "select a from Comentarios a where idObra = ?1";
    
    public Comentarios guardar(Comentarios comentarios){
        sessionFactory.getCurrentSession().save(comentarios);
        return comentarios;
    }
    
    public Comentarios actualizar(Comentarios comentarios){
        sessionFactory.getCurrentSession().merge(comentarios);
        sessionFactory.getCurrentSession().update(comentarios);
        return comentarios;
    }
    
    public void eliminar(Comentarios comentarios){
        sessionFactory.getCurrentSession().delete(comentarios);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Comentarios buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Comentarios.class, id);
    }
    
    public List<Comentarios> buscarComentariosPorIdObra(Integer idObra){
    		Query<Comentarios> resultados = sessionFactory.getCurrentSession().createQuery(QUERY1,Comentarios.class);
    		resultados.setParameter(1, idObra);
    		List<Comentarios> comentarios = resultados.list();
    		return comentarios.isEmpty()?new ArrayList<Comentarios>():comentarios;
    }
}
