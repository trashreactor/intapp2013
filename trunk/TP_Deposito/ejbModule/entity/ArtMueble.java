package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mueble")
public class ArtMueble extends Articulo {

	private String material;
	
	public ArtMueble(String nombre, String descripcion, float precio,
		String foto, int stock, String material, String marca, String origen){
		super(nombre,descripcion,precio, foto, stock, marca,origen);
		this.material=material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	

}
