/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.EstadoDenunciaDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.EstadoDenuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("estadoDenunciaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class EstadoDenunciaBs {
    @Autowired
    private EstadoDenunciaDao estadoDenunciaDao;
    
    @Transactional(rollbackFor = Exception.class)
    public EstadoDenuncia guardar(EstadoDenuncia estadoDenuncia){
        return estadoDenunciaDao.guardar(estadoDenuncia);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public EstadoDenuncia actualizar(EstadoDenuncia estadoDenucnia){
        EstadoDenuncia model = estadoDenunciaDao.buscarPorId(estadoDenucnia.getId());
        model.setEstado(estadoDenucnia.getEstado());
        return estadoDenunciaDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(EstadoDenuncia estadoDenuncia){
        estadoDenunciaDao.eliminar(estadoDenuncia);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        estadoDenunciaDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public EstadoDenuncia buscarPorId(Integer id){
        return estadoDenunciaDao.buscarPorId(id);
    }
}
