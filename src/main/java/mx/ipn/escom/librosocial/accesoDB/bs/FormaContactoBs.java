/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.bs;

import mx.ipn.escom.librosocial.accesoDB.dao.FormaContactoDao;
import mx.ipn.escom.librosocial.accesoDB.mapeo.FormaContacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("formaContactoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class FormaContactoBs {
    @Autowired
    private FormaContactoDao formaContactoDao;
    
    @Transactional(rollbackFor = Exception.class)
    public FormaContacto guardar(FormaContacto formaContacto){
        return formaContactoDao.guardar(formaContacto);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public FormaContacto actualizar(FormaContacto formaContacto){
        FormaContacto model = formaContactoDao.buscarPorId(formaContacto.getId());
        model.setIdRedSocial(formaContacto.getIdRedSocial());
        model.setIdUsuario(formaContacto.getIdUsuario());
        model.setRedesSociales(formaContacto.getRedesSociales());
        model.setUrl(formaContacto.getUrl());
        model.setUsuariosObj(formaContacto.getUsuariosObj());
        return formaContactoDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(FormaContacto formaContacto){
        formaContactoDao.eliminar(formaContacto);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        formaContactoDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public FormaContacto buscarPorId(Integer id){
        return formaContactoDao.buscarPorId(id);
    }
}
