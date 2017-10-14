/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.bs;

import mx.ipn.escom.librosocial.accesoDB.dao.SeguirObraDao;
import mx.ipn.escom.librosocial.accesoDB.mapeo.SeguirObra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("seguirObraBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class SeguirObraBs {
    @Autowired
    private SeguirObraDao seguirObraDao;
    
    @Transactional(rollbackFor = Exception.class)
    public SeguirObra guardar(SeguirObra seguirObra){
        return seguirObraDao.guardar(seguirObra);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public SeguirObra actualizar(SeguirObra seguirObra){
        SeguirObra model = seguirObraDao.buscarPorId(seguirObra.getId());
        model.setIdObra(seguirObra.getIdObra());
        model.setIdUsuario(seguirObra.getIdUsuario());
        model.setObras(seguirObra.getObras());
        model.setUsuarios(seguirObra.getUsuarios());
        return seguirObraDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(SeguirObra seguirObra){
        seguirObraDao.eliminar(seguirObra);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        seguirObraDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public SeguirObra buscarPorId(Integer id){
        return seguirObraDao.buscarPorId(id);
    }
}
