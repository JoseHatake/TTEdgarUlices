package mx.ipn.escom.socialwriters.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.socialwriters.accesoDB.mapeo.Notificacion;

@Service("notificacionDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class NotificacionDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Notificacion guardar(Notificacion notificacion) {
		sessionFactory.getCurrentSession().save(notificacion);
		return notificacion;
	}
	
	public Notificacion actualizar(Notificacion notificacion) {
		sessionFactory.getCurrentSession().merge(notificacion);
		sessionFactory.getCurrentSession().update(notificacion);
		return notificacion;
	}
	
	public void eliminar(Notificacion notificacion) {
		sessionFactory.getCurrentSession().delete(notificacion);
	}
	
	public void eliminar(Integer id) {
		this.eliminar(this.buscarPorId(id));
	}
	
	public Notificacion buscarPorId(Integer id) {
		return sessionFactory.getCurrentSession().load(Notificacion.class, id);
	}
}
