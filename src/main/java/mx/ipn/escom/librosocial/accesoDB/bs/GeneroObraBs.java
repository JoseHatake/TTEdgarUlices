/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.bs;

import mx.ipn.escom.librosocial.accesoDB.dao.GeneroObraDao;
import mx.ipn.escom.librosocial.accesoDB.mapeo.GeneroObra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("generoObraBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GeneroObraBs {
    @Autowired
    private GeneroObraDao generoObraDao;
    
    @Transactional(rollbackFor = Exception.class)
    public GeneroObra guardar(GeneroObra generoObra){
        return generoObraDao.guardar(generoObra);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public GeneroObra actualizar(GeneroObra generoObra){
        GeneroObra model = generoObraDao.buscarPorId(generoObra.getId());
        model.setIdGenero(generoObra.getIdGenero());
        model.setIdObra(generoObra.getIdObra());
        model.setObraObj(generoObra.getObraObj());
        model.setGenerosObj(generoObra.getGenerosObj());
        return generoObraDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(GeneroObra generoObra){
        generoObraDao.eliminar(generoObra);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        generoObraDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public GeneroObra buscarPorId(Integer id){
        return generoObraDao.buscarPorId(id);
    }
}
