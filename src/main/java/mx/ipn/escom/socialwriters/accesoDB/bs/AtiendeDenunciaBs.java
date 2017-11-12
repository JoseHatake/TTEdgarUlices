/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.AtiendeDenunciaDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.AtiendeDenuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("atiendeDenunciaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AtiendeDenunciaBs {
    @Autowired
    private AtiendeDenunciaDao atiendeDenunciaDao;
    
    @Transactional(rollbackFor = Exception.class)
    public AtiendeDenuncia guardar(AtiendeDenuncia atiendeDenuncia){
        return atiendeDenunciaDao.guardar(atiendeDenuncia);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public AtiendeDenuncia actualizar(AtiendeDenuncia atiendeDenuncia){
        AtiendeDenuncia model = atiendeDenunciaDao.buscarPorId(atiendeDenuncia.getId());
        model.setFecha(atiendeDenuncia.getFecha());
        model.setIdDenuncia(atiendeDenuncia.getIdDenuncia());
        model.setIdEstadoDenuncia(atiendeDenuncia.getIdEstadoDenuncia());
        model.setIdUsuario(atiendeDenuncia.getIdUsuario());
        model.setUsuarioObj(atiendeDenuncia.getUsuarioObj());
        model.setDenunciaObj(atiendeDenuncia.getDenunciaObj());
        model.setEstadoDenunciaObj(atiendeDenuncia.getEstadoDenunciaObj());
        return atiendeDenunciaDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(AtiendeDenuncia atiendeDenuncia){
        atiendeDenunciaDao.eliminar(atiendeDenuncia);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        atiendeDenunciaDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public AtiendeDenuncia busscarPorId(Integer id){
        return atiendeDenunciaDao.buscarPorId(id);
    }
}
