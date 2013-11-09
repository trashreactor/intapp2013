package entities;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Articulo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Articulo {
	@XmlAttribute(name = "CodArticulo")
	private int codArticulo;
	
	public Articulo(){}

	public int getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
	
	
}
