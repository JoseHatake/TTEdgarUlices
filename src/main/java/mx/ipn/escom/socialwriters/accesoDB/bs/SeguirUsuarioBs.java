/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.SeguirUsuarioDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.SeguirUsuario;

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
@Service("seguirUsuarioBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class SeguirUsuarioBs {
    @Autowired
    private SeguirUsuarioDao seguirUsuarioDao;
    
    @Transactional(rollbackFor = Exception.class)
    public SeguirUsuario guardar(SeguirUsuario segurUsuario){
        return seguirUsuarioDao.guardar(segurUsuario);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public SeguirUsuario actualizar(SeguirUsuario seguirUsuario){
        SeguirUsuario model = seguirUsuarioDao.buscarPorId(seguirUsuario.getId());
        model.setIdUsuarioSigue(seguirUsuario.getIdUsuarioSigue());
        model.setIdUsuarioSeguido(seguirUsuario.getIdUsuarioSeguido());
        return seguirUsuarioDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(SeguirUsuario seguirUsuario){
        seguirUsuarioDao.eliminar(seguirUsuario);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        seguirUsuarioDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public SeguirUsuario buscarPorId(Integer id){
        return seguirUsuarioDao.buscarPorId(id);
    }
    
    @Transactional(readOnly = true)
    public List<SeguirUsuario> buscarPorIdUsuario(Integer id) {
    		return seguirUsuarioDao.buscarPorIdUsuario(id);
    }
    
    @Transactional(readOnly = true)
    public Boolean verficarSeguirUsuario(Integer idUsuarioSigue, Integer idUsuarioSeguido) {
    		return seguirUsuarioDao.verficarSeguirUsuario(idUsuarioSigue, idUsuarioSeguido);
    }
    
    @Transactional(readOnly = true)
    public List<SeguirUsuario> buscarPorIdUsuarioSeguido(Integer id) {
    		return seguirUsuarioDao.buscarPorIdUsuarioSeguido(id);
    }
}
