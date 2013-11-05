package facade;

import java.util.List;

import javax.ejb.Remote;

import entity.vo.ArtElectroVO;
import entity.vo.ArtModaVO;
import entity.vo.ArtMuebleVO;
import entity.vo.ArtNinosVO;
import entity.vo.ArticuloVO;
import entity.vo.SolicitudCompraVO;



@Remote
public interface DepositoFacade {
	
	
	//articulo
	public void sumarStock(ArticuloVO a);
	public void crearArticuloModa(ArtModaVO moda);
	public void crearArticuloMueble(ArtMuebleVO mueble);
	public void crearArticuloNinos(ArtNinosVO ninos);
	public void crearArticuloElectro(ArtElectroVO electro);
	public List<ArticuloVO> getAllArticulos ();
	public ArticuloVO getArticulo (int id);
	public List<ArticuloVO> buscarArticulo(String stringBusqueda);
	
	//compras a fabrica
	public List<SolicitudCompraVO> getSolicitudesPendientes();
	
	
}