/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.DenunciaDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Denuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("denunciaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class DenunciaBs {
    @Autowired
    private DenunciaDao denunciaDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Denuncia guardar(Denuncia denuncia){
        return denunciaDao.guardar(denuncia);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Denuncia actualizar(Denuncia denuncia){
        Denuncia model = denunciaDao.buscarPorId(denuncia.getId());
        model.setDescripcion(denuncia.getDescripcion());
        model.setFecha(denuncia.getFecha());
        model.setIdDenunciaMotivo(denuncia.getIdDenunciaMotivo());
        model.setIdEstadoDenuncia(denuncia.getIdEstadoDenuncia());
        model.setIdObra(denuncia.getIdObra());
        model.setIdPais(denuncia.getIdPais());
        model.setIdUsuarioDenunciante(denuncia.getIdUsuarioDenunciante());
        model.setObraObj(denuncia.getObraObj());
        model.setPaisObj(denuncia.getPaisObj());
        model.setUsuarioDenuncianteObj(denuncia.getUsuarioDenuncianteObj());
        model.setDenunciaMotivoObj(denuncia.getDenunciaMotivoObj());
        model.setEstadoDenunciaObj(denuncia.getEstadoDenunciaObj());
        model.setEstadoDenunciaObj(denuncia.getEstadoDenunciaObj());
        return denunciaDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Denuncia denuncia){
        denunciaDao.eliminar(denuncia);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        denunciaDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Denuncia buscarPorId(Integer id){
        return denunciaDao.buscarPorId(id);
    }
}
