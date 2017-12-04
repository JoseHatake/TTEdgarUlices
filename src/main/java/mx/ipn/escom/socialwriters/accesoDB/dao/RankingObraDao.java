package mx.ipn.escom.socialwriters.accesoDB.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.RankingObra;

@Service("rankingObraDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class RankingObraDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	protected String QUERY1 = "select a from RankingObra a where idObra = ?1";
	protected String QUERY2 = "select a from RankingObra a where idObra = ?1 and idUsuario = ?2";
	
	public RankingObra guardar(RankingObra rankingObra) {
		sessionFactory.getCurrentSession().save(rankingObra);
		return rankingObra;
	}
	
	public RankingObra actualizar(RankingObra rankingObra) {
		sessionFactory.getCurrentSession().merge(rankingObra);
		sessionFactory.getCurrentSession().update(rankingObra);
		return rankingObra;
	}
	
	public void eliminar(RankingObra rankingObra) {
		sessionFactory.getCurrentSession().delete(rankingObra);
	}
	
	public void eliminar(Integer id) {
		this.eliminar(this.buscarPorId(id));
	}
	
	public RankingObra buscarPorId(Integer id) {
		return sessionFactory.getCurrentSession().load(RankingObra.class, id);
	}
	
	public List<RankingObra> buscarRankingPorIdObra(Integer idObra){
		Query<RankingObra> resultado = sessionFactory.getCurrentSession().createQuery(QUERY1,RankingObra.class);
		resultado.setParameter(1, idObra);
		List<RankingObra> ranking = resultado.list();
		return ranking.isEmpty()?new ArrayList<RankingObra>():ranking;
	}
	
	public Boolean verificaRankeo(Integer idObra,Integer idUsuario) {
		Query<RankingObra> resultado = sessionFactory.getCurrentSession().createQuery(QUERY2,RankingObra.class);
		resultado.setParameter(1, idObra);
		resultado.setParameter(2, idUsuario);
		List<RankingObra> ranking = resultado.list();
		return !ranking.isEmpty();
	}
	
	public RankingObra obtenerRankeo(Integer idObra,Integer idUsuario){
		Query<RankingObra> resultado = sessionFactory.getCurrentSession().createQuery(QUERY2,RankingObra.class);
		resultado.setParameter(1, idObra);
		resultado.setParameter(2, idUsuario);
		List<RankingObra> ranking = resultado.list();
		return ranking.get(0);
	}
}
