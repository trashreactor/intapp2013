package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Item")
public class ItemSolicitudXML {
	private int codArticulo;
	private int cantidad;
	
	public ItemSolicitudXML(){}
	
	@XmlElement(name = "CodigoArticulo")
	public int getCodArticulo() {
		return codArticulo;
	}
	
	@XmlElement(name = "Cantidad")
	public int getCantidad() {
		return cantidad;
	}

	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
