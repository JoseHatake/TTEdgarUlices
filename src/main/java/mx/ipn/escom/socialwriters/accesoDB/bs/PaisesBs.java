/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.PaisesDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Paises;

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
@Service("paisesBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PaisesBs {
    @Autowired
    private PaisesDao paisesDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Paises guardar(Paises paises){
        return paisesDao.guardar(paises);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Paises actualizar(Paises paises){
        Paises model = paisesDao.buscarPorId(paises.getId());
        model.setNombre(paises.getNombre());
        return paisesDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Paises paises){
        paisesDao.eliminar(paises);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        paisesDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Paises buscarPorId(Integer id){
        return paisesDao.buscarPorId(id);
    }
    
    @Transactional(readOnly = true)
    public List<Paises> listaPaises(){
    		return paisesDao.listaPaises();
    }
}
