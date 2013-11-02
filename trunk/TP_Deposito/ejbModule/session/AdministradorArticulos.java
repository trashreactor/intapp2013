package session;

import java.util.List;

import javax.ejb.Remote;

import entity.ArtElectro;
import entity.ArtModa;
import entity.ArtNinos;
import entity.Articulo;
import entity.ArtMueble;

@Remote
public interface AdministradorArticulos {
	
	public void crearArticuloMueble(ArtMueble mueble);
	public void crearArticuloModa(ArtModa moda);
	public void crearArticuloNinos(ArtNinos ninos);
	public void crearArticuloElectro(ArtElectro electro);
	public List<Articulo> getArticulosALL();
	
}
