package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Electro")

public class ArtElectro extends Articulo {

	private String fichaTecnica;
	
	public ArtElectro(String nombre, String descripcion, float precio,
		String foto, int stock, String fichaTecnica){
		super(nombre,descripcion,precio, foto, stock);
		this.fichaTecnica=fichaTecnica;
	}

	public String getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
	

}
