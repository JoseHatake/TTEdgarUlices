package mx.ipn.escom.socialwriters.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.socialwriters.accesoDB.dao.NotificacionDao;
import mx.ipn.escom.socialwriters.accesoDB.mapeo.Notificacion;

@Service("notificacionBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class NotificacionBs {
	@Autowired
	private NotificacionDao notificacionDao;
	
	public Notificacion guardar(Notificacion notificacion) {
		return notificacionDao.guardar(notificacion);
	}
	
	public Notificacion actualizar(Notificacion notificacion) {
		Notificacion model = this.buscarPorId(notificacion.getId());
		model.setTipo(notificacion.getTipo());
		model.setLeida(notificacion.getLeida());
		model.setIdUsuario(notificacion.getIdUsuario());
		model.setIdObra(notificacion.getIdObra());
		model.setUsuarioObj(notificacion.getUsuarioObj());
		model.setObraObj(notificacion.getObraObj());
		return notificacionDao.actualizar(model);
	}
	
	public void eliminar(Notificacion notificacion) {
		notificacionDao.eliminar(notificacion);
	}
	
	public void eliminar(Integer id) {
		notificacionDao.eliminar(id);
	}
	
	public Notificacion buscarPorId(Integer id) {
		return notificacionDao.buscarPorId(id);
	}
}
