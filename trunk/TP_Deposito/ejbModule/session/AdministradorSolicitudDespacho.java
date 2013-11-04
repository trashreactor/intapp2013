package session;

import java.util.List;

import javax.ejb.Remote;

import entity.ArtElectro;
import entity.ArtModa;
import entity.ArtNinos;
import entity.Articulo;
import entity.ArtMueble;
import entity.vo.SolicitudCompraVO;

@Remote
public interface AdministradorSolicitudDespacho {
	
	public List<SolicitudCompraVO> getSolicitudesDespachoPendientes();
	
	
}
