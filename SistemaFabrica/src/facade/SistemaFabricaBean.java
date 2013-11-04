package facade;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.*;
import javax.jms.ObjectMessage;
import javax.persistence.*;

import jms.ConexionJMS;
import entities.*;

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

	public void confirmarSolicitudes(List<Integer> nrosSolicitudes) throws Exception {
		List<SolicitudCompra> listaSolicitudes = new LinkedList<SolicitudCompra>();
		for(int nroSolicitud : nrosSolicitudes){
			SolicitudCompra solicitud = em.find(SolicitudCompra.class, nroSolicitud);
			solicitud.setEstado("Confirmada");
			RemitoCompra remito = dameElRemito(solicitud);
			enviarRemito(remito);
		}
	}
	
	private RemitoCompra dameElRemito(SolicitudCompra solicitud){
		return null;
	}
	
	private void enviarRemito(RemitoCompra remito) throws Exception {
		ConexionJMS conexion = new ConexionJMS();
		conexion.setUrl("localhost:4447");
		conexion.setUsuario("user");
		conexion.setContraseña("user1234");
		conexion.setDestino("jms/queue/test");
		conexion.enviarMensaje(remito);
	}


}
