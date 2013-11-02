package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mueble")
public class ArtMueble extends Articulo {

	private String material;
	
	public ArtMueble(String nombre, String descripcion, float precio,
		String foto, int stock, String material, String marca){
		super(nombre,descripcion,precio, foto, stock, marca);
		this.material=material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	

}
