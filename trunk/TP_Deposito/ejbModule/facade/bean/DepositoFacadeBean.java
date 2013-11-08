package facade.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.jms.Message;

import session.bean.AdministradorArticulosBean;
import xml.ConfirmarSolicitudesXML;
import entity.*;
import entity.vo.*;
import facade.DepositoFacade;

public @Stateless
class DepositoFacadeBean implements DepositoFacade {

	private static DepositoFacadeBean facade;
	private AdministradorArticulosBean administradorArticulosBean;

	AdministradorArticulosBean adminArticulos = new AdministradorArticulosBean();

	private DepositoFacadeBean() {
		administradorArticulosBean = AdministradorArticulosBean.getInstancia();

	}

	public static DepositoFacadeBean getInstanciaFacade() {
		if (facade == null)
			facade = new DepositoFacadeBean();
		return facade;
	}

	public void crearArticuloModa(ArtModaVO m) {
		ArtModa moda = new ArtModa(m.getNombre(), m.getDescripcion(),
				m.getPrecio(), m.getFoto(), m.getStock(), m.getColor(),
				m.getTalle(), m.getMarca(), m.getOrigen());
		administradorArticulosBean.getInstancia().crearArticuloModa(moda);
	}

	public void crearArticuloMueble(ArtMuebleVO m) {
		ArtMueble mueble = new ArtMueble(m.getNombre(), m.getDescripcion(),
				m.getPrecio(), m.getFoto(), m.getStock(), m.getMaterial(),
				m.getMarca(), m.getOrigen());
		administradorArticulosBean.getInstancia().crearArticuloMueble(mueble);
	}

	public void crearArticuloNinos(ArtNinosVO m) {
		ArtNinos ninios = new ArtNinos(m.getNombre(), m.getDescripcion(),
				m.getPrecio(), m.getFoto(), m.getStock(), m.getRangoEdad(),
				m.getMarca(), m.getOrigen());
		administradorArticulosBean.getInstancia().crearArticuloNinos(ninios);
	}

	public void crearArticuloElectro(ArtElectroVO m) {
		ArtElectro ele = new ArtElectro(m.getNombre(), m.getDescripcion(),
				m.getPrecio(), m.getFoto(), m.getStock(), m.getFichaTecnica(),
				m.getMarca(), m.getOrigen());
		administradorArticulosBean.getInstancia().crearArticuloElectro(ele);

	}

	@Override
	public List<ArticuloVO> getAllArticulos() {
		List<ArticuloVO> avoList = new ArrayList<ArticuloVO>();
		ArticuloVO avo;
		for (Articulo a : adminArticulos.getInstancia().getArticulosALL()) {
			avo = new ArticuloVO(a.getCodArticulo(), a.getDescripcion(),
					a.getPrecio(), a.getStock(), a.getMarca(), a.getOrigen());
			avoList.add(avo);
		}
		return avoList;
	}
	
	

	@Override
	public void sumarStock(ArticuloVO avo) {
		//¿Hay que hacer que articulo tenga un constructor aca?
		Articulo a = new Articulo(a.getCodArticulo(), a.getDescripcion(),
				a.getPrecio(), a.getStock(), a.getMarca(), a.getOrigen());

		adminArticulos.getInstancia().actualizarArticulo(avo.getStock(), a);

	}

	@Override
	public ArticuloVO getArticulo(int id) {
		Articulo a = adminArticulos.getInstancia().obtenerArticulo(id);
		ArticuloVO avo = new ArticuloVO(a.getCodArticulo(), a.getDescripcion(),
				a.getPrecio(), a.getStock(), a.getMarca(), a.getOrigen());
		return avo;
	}

	@Override
	public ArticuloVO buscarArticulo(String stringBusqueda) {
		Articulo a = adminArticulos.getInstancia().buscarArticulo(
				stringBusqueda);
		ArticuloVO avo = new ArticuloVO(a.getCodArticulo(), a.getDescripcion(),
				a.getPrecio(), a.getStock(), a.getMarca(), a.getOrigen());
		return avo;
	}

	@Override
	public List<SolicitudCompraVO> getSolicitudesCompraPendientes() {
		return null;
	}

	
	

}
