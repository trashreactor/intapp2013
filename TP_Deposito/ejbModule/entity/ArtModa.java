package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;






@Entity
@DiscriminatorValue("Moda")

public class ArtModa extends Articulo {

	private String color;
	private String talle;
	
	public ArtModa(String nombre, String descripcion, float precio,
		String foto, int stock, String color, String talle, String marca, String origen){
		super(nombre,descripcion,precio, foto, stock, marca, origen);
		this.color=color;
		this.talle=talle; // agregado eric, se ve q por esto no persistia el campo talle
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}
	

}
