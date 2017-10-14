/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.bs;

import mx.ipn.escom.librosocial.accesoDB.dao.IdiomaDao;
import mx.ipn.escom.librosocial.accesoDB.mapeo.Idioma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("idiomaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class IdiomaBs {
    @Autowired
    private IdiomaDao idiomaDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Idioma guardar(Idioma idioma){
        return idiomaDao.guardar(idioma);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Idioma actualizar(Idioma idioma){
        Idioma model = idiomaDao.buscarPorId(idioma.getId());
        model.setIdioma(idioma.getIdioma());
        return idiomaDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Idioma idioma){
        idiomaDao.eliminar(idioma);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        idiomaDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Idioma buscarPorId(Integer id){
        return idiomaDao.buscarPorId(id);
    }
}
