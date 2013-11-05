package session.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import session.AdministradorArticulos;
import session.AdministradorSolicitudCompra;
import entity.ArtElectro;
import entity.ArtModa;
import entity.ArtMueble;
import entity.ArtNinos;
import entity.Articulo;
import entity.SolicitudCompra;
import entity.vo.SolicitudCompraVO;

@Stateless
public class AdministradorSolicitudCompraBean implements AdministradorSolicitudCompra {
	
	@PersistenceContext(unitName="CRM")
    private EntityManager em;


	private static AdministradorSolicitudCompraBean administradorSolicitudCompraBean;
	public static AdministradorSolicitudCompraBean getInstancia(){
		if (administradorSolicitudCompraBean==null)
			administradorSolicitudCompraBean=new AdministradorSolicitudCompraBean();
		return administradorSolicitudCompraBean;
	}
	
	
	
	
	@Override
	public List<SolicitudCompraVO> getSolicitudesCompraPendientes() {
		Query q = (Query) em.createQuery("select codArticulo, nombre,descripcion, precio, stock  from articulos").getResultList();
		
		
	}



}
