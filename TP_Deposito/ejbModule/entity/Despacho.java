package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Despacho")

public class Despacho {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDespacho;
	
	private String descripcion;
	
	private String ip;
	
	
	public Despacho() {

	}

	public void setIdDespacho (int id){
		this.idDespacho=id;
	}
	
	public int getIdDespacho(){
		return idDespacho;
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
