/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.DenunciaMotivoDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.DenunciaMotivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("denunciaMotivoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class DenunciaMotivoBs {
    @Autowired
    private DenunciaMotivoDao denunciaMotivoDao;
    
    @Transactional(rollbackFor = Exception.class)
    public DenunciaMotivo guardar(DenunciaMotivo denunciaMotivo){
        return denunciaMotivoDao.guardar(denunciaMotivo);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public DenunciaMotivo actualizar(DenunciaMotivo denunciaMotivo){
        DenunciaMotivo model = denunciaMotivoDao.buscarPorId(denunciaMotivo.getId());
        model.setMotivo(denunciaMotivo.getMotivo());
        return denunciaMotivoDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(DenunciaMotivo denunciaMotivo){
        denunciaMotivoDao.eliminar(denunciaMotivo);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        denunciaMotivoDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public DenunciaMotivo buscarPorId(Integer id){
        return denunciaMotivoDao.buscarPorId(id);
    }
}
