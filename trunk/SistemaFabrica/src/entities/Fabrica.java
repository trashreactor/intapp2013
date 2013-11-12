package entities;

import javax.persistence.*;

@Entity
@Table(name="Fabrica")
public class Fabrica {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "IdFabrica")
	private int idFabrica;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "IP")
	private String ip;

	public Fabrica() {}

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
