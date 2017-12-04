/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import java.util.ArrayList;
import java.util.List;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Capitulo;
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
@Service("capituloDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class CapituloDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    protected String QUERY1 = "select a from Capitulo a where nombre like concat('%',?1,'%')";
    protected String QUERY2 = "select a from Capitulo a where idObra = ?1";
    
    public Capitulo guardar(Capitulo capitulo){
        sessionFactory.getCurrentSession().save(capitulo);
        return capitulo;
    }
    
    public Capitulo actualizar(Capitulo capitulo){
        sessionFactory.getCurrentSession().merge(capitulo);
        sessionFactory.getCurrentSession().update(capitulo);
        return capitulo;
    }
    
    public void eliminar(Capitulo capitulo){
        sessionFactory.getCurrentSession().delete(capitulo);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public Capitulo buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(Capitulo.class, id);
    }
    
    public List<Capitulo> buscarPorNombre(String nombre){
        Query<Capitulo> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,Capitulo.class);
        resultado.setParameter(1, nombre);
        List<Capitulo> capitulos = resultado.list();
        return capitulos.isEmpty()?new ArrayList<>():capitulos;
    }
    
    public List<Capitulo> buscarPorIdObra(Integer idObra){
        Query<Capitulo> resultado = sessionFactory.getCurrentSession().createQuery(QUERY2,Capitulo.class);
        resultado.setParameter(1, idObra);
        List<Capitulo> capitulos = resultado.list();
        return capitulos.isEmpty()?new ArrayList<>():capitulos;
    }
}
