/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.GeneroDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("generosBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GeneroBs {
    @Autowired
    private GeneroDao generoDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Genero guardar(Genero genero){
        return generoDao.guardar(genero);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Genero actualizar(Genero genero){
        Genero model = generoDao.buscarPorId(genero.getId());
        model.setGenero(genero.getGenero());
        return generoDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Genero genero){
        generoDao.eliminar(genero);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        generoDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Genero buscarPorId(Integer id){
        return generoDao.buscarPorId(id);
    }
}
