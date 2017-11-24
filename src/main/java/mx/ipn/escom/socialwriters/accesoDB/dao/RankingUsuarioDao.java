/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.dao;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.RankingUsuario;

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
@Service("rankingUsuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class RankingUsuarioDao {
    @Autowired
	private SessionFactory sessionFactory;
    
    protected String QUERY1 = "select a from RankingUsuario a where idUsuarioRankeado = ?1";
    
    public RankingUsuario guardar(RankingUsuario rankingUsuario){
        sessionFactory.getCurrentSession().save(rankingUsuario);
        return rankingUsuario;
    }
    
    public RankingUsuario actualizar(RankingUsuario rankingUsuario){
        sessionFactory.getCurrentSession().merge(rankingUsuario);
        sessionFactory.getCurrentSession().update(rankingUsuario);
        return rankingUsuario;
    }
    
    public void eliminar(RankingUsuario rankingUsuario){
        sessionFactory.getCurrentSession().delete(rankingUsuario);
    }
    
    public void eliminar(Integer id){
        this.eliminar(this.buscarPorId(id));
    }
    
    public RankingUsuario buscarPorId(Integer id){
        return sessionFactory.getCurrentSession().load(RankingUsuario.class, id);
    }
    
    public List<RankingUsuario> buscarUsuariosRankea(Integer idUsuarioRankeado){
    		Query<RankingUsuario> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,RankingUsuario.class);
    		resultado.setParameter(1, idUsuarioRankeado);
    		List<RankingUsuario> usuariosRankea = resultado.list();
    		return usuariosRankea.isEmpty()?new ArrayList<RankingUsuario>():usuariosRankea;
    }
}
