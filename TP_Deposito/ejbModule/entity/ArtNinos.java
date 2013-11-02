package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ninos")

public class ArtNinos extends Articulo {

	private String rangoEdad;
	
	public ArtNinos(String nombre, String descripcion, float precio,
		String foto, int stock, String rangoEdad, String marca){
		super(nombre,descripcion,precio, foto, stock, marca);
		this.rangoEdad=rangoEdad;
	}

	public String getRangoEdad() {
		return rangoEdad;
	}

	public void setRangoEdad(String rangoEdad) {
		this.rangoEdad = rangoEdad;
	}
	

}
