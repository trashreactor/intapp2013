package facade.bean;

import java.util.List;

import javax.ejb.Stateless;

import entity.vo.ArtElectroVO;
import entity.vo.ArtModaVO;
import entity.vo.ArtMuebleVO;
import entity.vo.ArtNinosVO;
import entity.vo.ArticuloVO;
import entity.vo.SolicitudCompraVO;
import facade.DepositoFacade;

public @Stateless class DepositoFacadeBean implements DepositoFacade{

	@Override
	public void crearArticuloModa(ArtModaVO moda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearArticuloMueble(ArtMuebleVO mueble) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearArticuloNinos(ArtNinosVO ninos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearArticuloElectro(ArtElectroVO electro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticuloVO> getAllArticulos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sumarStock(ArticuloVO a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SolicitudCompraVO> getSolicitudesPendientes() {
		return null;
		
		
	}
	
}
