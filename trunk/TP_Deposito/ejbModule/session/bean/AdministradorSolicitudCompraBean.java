package session.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.ArtModa;
import entity.SolicitudCompra;
import session.AdministradorSolicitudCompra;

public class AdministradorSolicitudCompraBean implements AdministradorSolicitudCompra {


	@PersistenceContext(unitName="CRM")
    private EntityManager em;
	//lalalla

	@Override
	public void crearSolicitudCompraFabrica(SolicitudCompra solicitd) {
		em.persist(solicitd);
		
	}

}
