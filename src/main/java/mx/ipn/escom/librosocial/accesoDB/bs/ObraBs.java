/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.librosocial.accesoDB.bs;

import mx.ipn.escom.librosocial.accesoDB.dao.ObraDao;
import mx.ipn.escom.librosocial.accesoDB.mapeo.Obra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("obraBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ObraBs {
    @Autowired
    private ObraDao obraDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Obra guardar(Obra obra){
        return obraDao.guardar(obra);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Obra actualizar(Obra obra){
        Obra model = obraDao.buscarPorId(obra.getId());
        model.setIdIdioma(obra.getIdIdioma());
        model.setIdUsuario(obra.getIdUsuario());
        model.setNombre(obra.getNombre());
        model.setSinopsis(obra.getSinopsis());
        model.setIdiomaObj(obra.getIdiomaObj());
        model.setUsuarioObj(obra.getUsuarioObj());
        return obraDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Obra obra){
        obraDao.eliminar(obra);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        obraDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Obra buscarPorId(Integer id){
        return obraDao.buscarPorId(id);
    }
}
