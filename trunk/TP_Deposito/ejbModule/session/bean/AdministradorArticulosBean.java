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
import facade.bean.DepositoFacadeBean;

@Stateless
public class AdministradorArticulosBean implements AdministradorArticulos {

	@PersistenceContext(unitName = "CRM")
	private EntityManager em;

	private static AdministradorArticulosBean administradorArticulosBean;

	public static AdministradorArticulosBean getInstancia() {
		if (administradorArticulosBean == null)
			administradorArticulosBean = new AdministradorArticulosBean();
		return administradorArticulosBean;
	}

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
		Query q = (Query) em
				.createQuery(
						"select codArticulo, nombre,descripcion, precio, stock  from articulos")
				.getResultList();
		@SuppressWarnings("unchecked")
		List<Articulo> articulos = (List<Articulo>) q.getResultList();
		return articulos;
	}

	public void actualizarListaArticulos(int cantidad, List<Articulo> articulos) {

		for (Articulo art : articulos) {
			Articulo art2 = em.find(Articulo.class, art.getCodArticulo());
			if (art2 != null) {
				art2.setStock(cantidad + art2.getStock());
				em.merge(art2);
			}
		}

	}

	public void actualizarArticulo(int cantidad, Articulo articulo) {
		Articulo art = em.find(Articulo.class, articulo.getCodArticulo());
		if (art != null) {
			art.setStock(cantidad + art.getStock());
			em.merge(art);
		}
	}

	@Override
	public Articulo obtenerArticulo(int codArticulo) {
		Articulo articulo = em.find(Articulo.class, codArticulo);
		return articulo;
	}

	public Articulo buscarArticulo(String stringBusqueda) {
		Query q = (Query) em
				.createQuery(
						"select codArticulo, nombre,descripcion, precio, stock  from articulos where nombre like '%:keyword%'")
				.setParameter("keyword", stringBusqueda);

		@SuppressWarnings("unchecked")
		Articulo a = (Articulo) q.getResultList();
		return a;
	}
}
