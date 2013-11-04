package session.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import session.AdministradorArticulos;
import session.AdministradorSolicitudDespacho;
import entity.ArtElectro;
import entity.ArtModa;
import entity.ArtMueble;
import entity.ArtNinos;
import entity.Articulo;
import entity.vo.SolicitudCompraVO;

@Stateless
public class AdministradorSolicitudDespachoBean implements AdministradorSolicitudDespacho {
	
	@PersistenceContext(unitName="CRM")
    private EntityManager em;


	@Override
	public List<SolicitudCompraVO> getSolicitudesDespachoPendientes() {
		Query q = (Query) em.createQuery("select *  from SolicitudDespacho inner s join ").getResultList();
		@SuppressWarnings("unchecked")
		List<Articulo> articulos = (List<Articulo>)q.getResultList();
		return articulos;
		
		
	}


	
	
	

	

}
