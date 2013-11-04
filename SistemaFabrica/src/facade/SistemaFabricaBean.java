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

	@Override
	public void enviarSolicitud(SolicitudCompra solicitud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SolicitudCompra> obtenerSolicitudes() {
		// TODO Auto-generated method stub
		return null;
	}
}
