/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.bs;

import mx.ipn.escom.librosocial.accesoDB.dao.RankingUsuarioDao;
import mx.ipn.escom.librosocial.accesoDB.mapeo.RankingUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("rankingUsuarioBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class RankingUsuarioBs {
    @Autowired
    private RankingUsuarioDao rankingUsuarioDao;
    
    @Transactional(rollbackFor = Exception.class)
    public RankingUsuario guardar(RankingUsuario rankingUsuario){
        return rankingUsuarioDao.guardar(rankingUsuario);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public RankingUsuario actualizar(RankingUsuario rankingUsuario){
        RankingUsuario model = rankingUsuarioDao.buscarPorId(rankingUsuario.getId());
        model.setEstrellas(rankingUsuario.getEstrellas());
        model.setIdUsuarioRankea(rankingUsuario.getIdUsuarioRankea());
        model.setIdUsuarioRankeado(rankingUsuario.getIdUsuarioRankeado());
        model.setUsuariosRankea(rankingUsuario.getUsuariosRankea());
        model.setUsuarioRankeado(rankingUsuario.getUsuarioRankeado());
        return rankingUsuarioDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(RankingUsuario rankingUsuario){
        rankingUsuarioDao.eliminar(rankingUsuario);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        rankingUsuarioDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public RankingUsuario buscarPorId(Integer id){
        return rankingUsuarioDao.buscarPorId(id);
    }
}
