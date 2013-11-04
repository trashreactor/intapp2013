package facade;

import java.util.List;

import javax.ejb.*;
import javax.persistence.*;

import entities.SolicitudCompra;

@Stateless
@LocalBean
public class SistemaFabricaBean implements SistemaFabrica{
	@PersistenceContext
	private EntityManager em;
	
	public SistemaFabricaBean(){}

	public void enviarSolicitud(SolicitudCompra solicitud) {
		em.persist(solicitud);
	}

	@SuppressWarnings("unchecked")
	public List<SolicitudCompra> obtenerSolicitudes() {
		String sql = "SELECT * FROM SolicitudeCompra";
		Query query = em.createQuery(sql);
		return query.getResultList();
	}
}
