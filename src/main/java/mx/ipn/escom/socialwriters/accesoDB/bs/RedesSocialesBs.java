/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.RedesSocialesDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.RedesSociales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("redesSocialesBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class RedesSocialesBs {
    @Autowired
    private RedesSocialesDao redesSocialesDao;
    
    @Transactional(rollbackFor = Exception.class)
    public RedesSociales guardar(RedesSociales redesSociales){
        return redesSocialesDao.guardar(redesSociales);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public RedesSociales actualizar(RedesSociales redesSociales){
        RedesSociales model = redesSocialesDao.buscarPorId(redesSociales.getIdRedSocial());
        model.setNombre(redesSociales.getNombre());
        return redesSocialesDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(RedesSociales redesSociales){
        redesSocialesDao.eliminar(redesSociales);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        redesSocialesDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public RedesSociales buscarPorId(Integer id){
        return redesSocialesDao.buscarPorId(id);
    }
    
    @Transactional(readOnly = true)
    public List<RedesSociales> todasLasRedes(){
    		return redesSocialesDao.todasLasRedes();
    }
}
