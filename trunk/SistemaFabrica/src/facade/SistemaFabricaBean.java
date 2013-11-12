package facade;

import java.util.List;

import javax.ejb.*;
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
		if(em.find(SolicitudCompra.class, solicitud.getNroSolicitudCompra()) == null)
			em.persist(solicitud);
	}

	@SuppressWarnings("unchecked")
	public List<SolicitudCompra> obtenerSolicitudes() {
		String sql = "SELECT * FROM SolicitudeCompra";
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

	public void confirmarSolicitudes(String nrosSolicitudes) throws Exception {
		String[] nrosSolicitudesSplited = nrosSolicitudes.split(",");
		for(String nroSolicitudChar : nrosSolicitudesSplited){
			int nroSolicitud = Integer.parseInt(nroSolicitudChar);
			SolicitudCompra solicitud = em.find(SolicitudCompra.class, nroSolicitud);
			solicitud.setEstado("Satisfecha");
			RemitoCompra remito = convertirRemito(solicitud);
			em.persist(remito);
			enviarRemito(remito);
		}
	}
	
	private RemitoCompra convertirRemito(SolicitudCompra solicitud){
		RemitoCompra remito = new RemitoCompra();
		for(ItemSolicitudCompra itemS : solicitud.getItems()){
			ItemRemitoCompra itemR = new ItemRemitoCompra();
			itemR.setArticulo(itemS.getArticulo());
			itemR.setCantidad(itemS.getCantidad());
			remito.addItem(itemR);
		}
		return remito;
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
