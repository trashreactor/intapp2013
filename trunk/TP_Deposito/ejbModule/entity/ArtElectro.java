package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Electro")

public class ArtElectro extends Articulo {

	private String fichaTecnica;
	
	public ArtElectro(String nombre, String descripcion, float precio,
		String foto, int stock, String fichaTecnica, String marca){
		super(nombre,descripcion,precio, foto, stock, marca);
		this.fichaTecnica=fichaTecnica;
	}

	public String getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
	

}
