/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.bs;

import mx.ipn.escom.socialwriters.accesoDB.dao.PersonaDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josemiguel
 */
@Service("personaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PersonaBs {
    @Autowired
    private PersonaDao personaDao;
    
    @Transactional(rollbackFor = Exception.class)
    public Persona guardar(Persona persona){
        return personaDao.guardar(persona);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Persona actualizar(Persona persona){
        Persona model = personaDao.buscarPorId(persona.getId());
        model.setNombre(persona.getNombre());
        model.setPaterno(persona.getPaterno());
        model.setMaterno(persona.getMaterno());
        model.setFechaNacimiento(persona.getFechaNacimiento());
        model.setSexo(persona.getSexo());
        model.setIdPais(persona.getIdPais());
        model.setPaisObj(persona.getPaisObj());
        return personaDao.actualizar(model);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Persona persona){
        personaDao.eliminar(persona);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar(Integer id){
        personaDao.eliminar(id);
    }
    
    @Transactional(readOnly = true)
    public Persona buscarPorId(Integer id){
        return personaDao.buscarPorId(id);
    }
}
