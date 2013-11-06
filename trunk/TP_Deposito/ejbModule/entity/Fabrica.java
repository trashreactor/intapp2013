package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fabrica")

public class Fabrica {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFabrica;
	
	private String descripcion;
	
	private String ip;

	
	
	public Fabrica() {
	
	}

	public void setIdFabrica(int idFabrica){
		this.idFabrica=idFabrica;
	}
	
	public int getIdFabrica(){
		return idFabrica;
	}
	
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}

	

}
