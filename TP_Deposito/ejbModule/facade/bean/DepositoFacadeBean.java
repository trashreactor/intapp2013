package facade.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import session.bean.AdministradorArticulosBean;
import entity.*;
import entity.vo.*;

import entity.vo.ArtElectroVO;
import entity.vo.ArtModaVO;
import entity.vo.ArtMuebleVO;
import entity.vo.ArtNinosVO;
import entity.vo.ArticuloVO;
import entity.vo.SolicitudCompraVO;
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

	@Override
	public void crearArticuloModa(ArtModaVO m) {
		ArtModa moda = new ArtModa(m.getNombre(), m.getDescripcion(),
				m.getPrecio(), m.getFoto(), m.getStock(), m.getColor(),
				m.getTalle(), m.getMarca(), m.getOrigen());
		administradorArticulosBean.getInstancia().crearArticuloModa(moda);
	}

	@Override
	public void crearArticuloMueble(ArtMuebleVO m) {
		ArtMueble mueble = new ArtMueble(m.getNombre(), m.getDescripcion(),
				m.getPrecio(), m.getFoto(), m.getStock(), m.getMaterial(),
				m.getMarca(), m.getOrigen());
		administradorArticulosBean.getInstancia().crearArticuloMueble(mueble);
	}

	@Override
	public void crearArticuloNinos(ArtNinosVO m) {
		ArtNinos ninios = new ArtNinos(m.getNombre(), m.getDescripcion(),
				m.getPrecio(), m.getFoto(), m.getStock(), m.getRangoEdad(),
				m.getMarca(), m.getOrigen());
		administradorArticulosBean.getInstancia().crearArticuloNinos(ninios);
	}

	@Override
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
		
		Articulo a = new Articulo(a.getCodArticulo(), a.getDescripcion(),
				a.getPrecio(), a.getStock(), a.getMarca(), a.getOrigen());
		
		adminArticulos.getInstancia().actualizarArticulo(avo.getStock(), a);
			
	}

	@Override
	public ArticuloVO getArticulo(int id) {
		Articulo a = adminArticulos.getInstancia().obtenerArticulo(id);
		ArticuloVO avo= new ArticuloVO(a.getCodArticulo(), a.getDescripcion(),
				a.getPrecio(), a.getStock(), a.getMarca(), a.getOrigen());
		return avo;
	}

	@Override
	public List<ArticuloVO> buscarArticulo(String stringBusqueda) {
		Articulo a = adminArticulos.getInstancia().buscarArticulo( stringBusqueda);
		ArticuloVO avo= new ArticuloVO(a.getCodArticulo(), a.getDescripcion(),
				a.getPrecio(), a.getStock(), a.getMarca(), a.getOrigen());
		return avo;
	}




	@Override
	public List<SolicitudCompraVO> getSolicitudesPendientes() {
		return null;
		
		
	}
	
}
