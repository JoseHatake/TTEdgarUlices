/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.UsuarioDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("usuarioBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioBs {
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Usuario guardar(Usuario usuario){
        return usuarioDao.guardar(usuario);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Usuario actualizar(Usuario usuario){
        Usuario model = usuarioDao.buscarPorId(usuario.getId());
        model.setNick(usuario.getNick());
        model.setCorreo(usuario.getCorreo());
        model.setClave(usuario.getClave());
        model.setIdPerfil(usuario.getIdPerfil());
        model.setIdPersona(usuario.getIdPersona());
        model.setPerfilObj(usuario.getPerfilObj());
        model.setEstadoCuenta(usuario.getEstadoCuenta());
        return usuarioDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Usuario usuario){
        usuarioDao.eliminar(usuario);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        usuarioDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Integer id){
        return usuarioDao.buscarPorId(id);
    }
    
    @Transactional(readOnly = true)
    public Boolean validaNick(String nickName) {
    		return usuarioDao.validaNick(nickName);
    }
    
    @Transactional(readOnly = true)
	public Boolean validaCorreo(String correo) {
		return usuarioDao.validaCorreo(correo);
	}
    
    @Transactional(readOnly = true)
    public Usuario validaLogIn(String nick,Integer claveHash) {
    		return usuarioDao.validaLogIn(nick, claveHash);
    }
    
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioPorCorreo (String correo) {
    	return usuarioDao.buscarUsuarioPorCorreo(correo);
    }
}
