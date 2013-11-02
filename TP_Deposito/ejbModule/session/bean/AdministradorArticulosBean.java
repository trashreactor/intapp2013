package session.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import session.AdministradorArticulos;
import entity.ArtElectro;
import entity.ArtModa;
import entity.ArtMueble;
import entity.ArtNinos;
import entity.Articulo;

@Stateless
public class AdministradorArticulosBean implements AdministradorArticulos {
	
	@PersistenceContext(unitName="CRM")
    private EntityManager em;
	
	
	public void crearArticuloMueble(ArtMueble mueble) {
		em.persist(mueble);
	}


	@Override
	public void crearArticuloModa(ArtModa moda) {
		em.persist(moda);
		
	}



	@Override
	public void crearArticuloNinos(ArtNinos ninos) {
		em.persist(ninos);
		
	}


	@Override
	public void crearArticuloElectro(ArtElectro electro) {
		em.persist(electro);
		
	}

	
	@Override
	public List<Articulo> getArticulosALL() {
		Query q = (Query) em.createQuery("select codArticulo, nombre,descripcion, precio, stock  from articulos").getResultList();
		@SuppressWarnings("unchecked")
		List<Articulo> articulos = (List<Articulo>)q.getResultList();
		return articulos;
	}

	

}
