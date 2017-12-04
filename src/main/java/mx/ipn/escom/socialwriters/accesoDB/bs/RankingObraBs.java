package mx.ipn.escom.socialwriters.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.socialwriters.accesoDB.dao.RankingObraDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.RankingObra;

@Service("rankingObraBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class RankingObraBs {
	@Autowired
	private RankingObraDao rankingObraDao;
	
	@Transactional(rollbackFor = Exception.class)
	public RankingObra guardar(RankingObra rankingObra) {
		return rankingObraDao.guardar(rankingObra);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public RankingObra actualizar(RankingObra rankingObra) {
		RankingObra model = buscarPorId(rankingObra.getId());
		model.setEstrellas(rankingObra.getEstrellas());
		model.setIdObra(rankingObra.getIdObra());
		model.setIdUsuario(rankingObra.getIdUsuario());
		return rankingObraDao.actualizar(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void eliminar(RankingObra rankingObra) {
		rankingObraDao.eliminar(rankingObra);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void eliminar(Integer id) {
		rankingObraDao.eliminar(id);
	}
	
	@Transactional(readOnly = true)
	public RankingObra buscarPorId(Integer id) {
		return rankingObraDao.buscarPorId(id);
	}
	
	@Transactional(readOnly = true)
	public List<RankingObra> buscarRankingPorIdObra(Integer idObra){
		return rankingObraDao.buscarRankingPorIdObra(idObra);
	}
	
	@Transactional(readOnly = true)
	public Boolean verificaRankeo(Integer idObra,Integer idUsuario) {
		return rankingObraDao.verificaRankeo(idObra, idUsuario);
	}
	
	@Transactional(readOnly = true)
	public RankingObra obtenerRankeo(Integer idObra,Integer idUsuario){
		return rankingObraDao.obtenerRankeo(idObra, idUsuario);
	}
}
