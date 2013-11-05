package model;

import java.util.Hashtable;
import java.util.List;

import javax.naming.InitialContext;

import facade.DepositoFacade;
import entity.vo.*;

public class BusinessDelegate {

	private DepositoFacade depositoFacade;
	private InitialContext initialContext;
	private String naming = "TP_Deposito/facade/bean/DepositoFacadeBean/remote";

	public BusinessDelegate() {
		inicializarContexto();
	}

	private DepositoFacade getDepositoFacade() {
		try {
			if (depositoFacade == null) {
				depositoFacade = (DepositoFacade) initialContext.lookup(naming);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return depositoFacade;
	}

	private void inicializarContexto() {
		try {
			Hashtable props = new Hashtable();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			// Url completa de ubicacion del servidor de aplicaciones
			props.put(InitialContext.PROVIDER_URL, "jnp://127.0.0.1:1099");
			// Objeto del tipo InitialContext
			initialContext = new InitialContext(props);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Articulos
	public List<ArticuloVO> buscarArticulo(String stringBusqueda) {
		return getDepositoFacade().buscarArticulo(stringBusqueda);
	}

	public List<ArticuloVO> getArticulosALL() {
		return getDepositoFacade().getAllArticulos();
	}

	public ArticuloVO getArticulo(int id) {
		return getDepositoFacade().getArticulo(id);
	}

	public void sumarStock(ArticuloVO a) {
		getDepositoFacade().sumarStock(a);
	}

	public void crearArticuloModa(ArtModaVO a) {
		getDepositoFacade().crearArticuloModa(a);
	}

	public void crearArticuloNinos(ArtNinosVO a) {
		getDepositoFacade().crearArticuloNinos(a);
	}

	public void crearArticuloMueble(ArtMuebleVO a) {
		getDepositoFacade().crearArticuloMueble(a);
	}

	public void crearArticuloElectro(ArtElectroVO a) {
		getDepositoFacade().crearArticuloElectro(a);
	}
}
