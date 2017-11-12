/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.PerfilDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("perfilBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PerfilBs {
    @Autowired
    private PerfilDao perfilDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Perfil guardar(Perfil perfil){
        return perfilDao.guardar(perfil);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Perfil actualizar(Perfil perfil){
        Perfil model = perfilDao.buscarPorId(perfil.getId());
        model.setDescripcion(perfil.getDescripcion());
        model.setNumSeguidores(perfil.getNumSeguidores());
        model.setRol(perfil.getRol());
        return perfilDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Perfil perfil){
        perfilDao.eliminar(perfil);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        perfilDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Perfil buscarPorId(Integer id){
        return perfilDao.buscarPorId(id);
    }
}
