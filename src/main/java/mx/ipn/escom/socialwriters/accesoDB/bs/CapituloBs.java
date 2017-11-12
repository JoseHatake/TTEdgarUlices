/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import java.util.List;
import mx.ipn.escom.socialwriters.accesoDB.dao.CapituloDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Capitulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("capituloBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class CapituloBs {
    @Autowired
    private CapituloDao capituloDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Capitulo guardar(Capitulo capitulo){
        return capituloDao.guardar(capitulo);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Capitulo actualizar(Capitulo capitulo){
        Capitulo model = capituloDao.buscarPorId(capitulo.getId());
        model.setNombre(capitulo.getNombre());
        model.setNumero(capitulo.getNumero());
        model.setIdObra(capitulo.getIdObra());
        return capituloDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Capitulo capitulo){
        capituloDao.eliminar(capitulo);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        capituloDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Capitulo buscarPorId(Integer id){
        return capituloDao.buscarPorId(id);
    }
    
    @Transactional(readOnly = true)
    public List<Capitulo> buscarPorNombre(String nombre){
        return capituloDao.buscarPorNombre(nombre);
    }
    
    @Transactional(readOnly = true)
    public List<Capitulo> buscarPorIdObra(Integer idObra){
        return capituloDao.buscarPorIdObra(idObra);
    }
}
