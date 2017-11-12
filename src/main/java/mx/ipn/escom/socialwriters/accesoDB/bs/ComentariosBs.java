/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.ComentariosDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("comentariosBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ComentariosBs {
    @Autowired
    private ComentariosDao comentariosDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Comentarios guardar(Comentarios comentarios){
        return comentariosDao.guardar(comentarios);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Comentarios actualizar(Comentarios comentarios){
        Comentarios model = comentariosDao.buscarPorId(comentarios.getId());
        model.setComentario(comentarios.getComentario());
        model.setFechaHora(comentarios.getFechaHora());
        model.setIdObra(comentarios.getIdObra());
        model.setIdUsuario(comentarios.getIdUsuario());
        model.setObraObj(comentarios.getObraObj());
        model.setUsuario(comentarios.getUsuario());
        return comentariosDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Comentarios comentarios){
        comentariosDao.eliminar(comentarios);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        comentariosDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Comentarios buscarPorId(Integer id){
        return comentariosDao.buscarPorId(id);
    }
}
