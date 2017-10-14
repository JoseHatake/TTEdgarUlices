/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.bs;

import mx.ipn.escom.librosocial.accesoDB.dao.AlertasDao;
import mx.ipn.escom.librosocial.accesoDB.mapeo.Alertas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("alertasBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AlertasBs {
    @Autowired
    private AlertasDao alertasDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Alertas guardar(Alertas alertas){
        return alertasDao.guardar(alertas);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Alertas actualizar(Alertas alertas){
        Alertas model = alertasDao.buscarPorId(alertas.getId());
        model.setEstatus(alertas.getEstatus());
        model.setIdObra(alertas.getIdObra());
        model.setIdUsuario(alertas.getIdUsuario());
        model.setTipoAlerta(alertas.getTipoAlerta());
        model.setObra(alertas.getObra());
        model.setUsuario(alertas.getUsuario());
        return alertasDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Alertas alertas){
        alertasDao.eliminar(alertas);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        alertasDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Alertas buscarPorId(Integer id){
        return alertasDao.buscarPorId(id);
    }
}
