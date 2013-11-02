package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SolicitudDespacho")

public class SolicitudDespacho {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroSolicitudDespacho;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nroSolicitudDespacho")
	private List<ItemSolicitudDespacho> items;
	
	private String estado;
	
	private float total;
	
	@OneToOne
	@JoinColumn(name="idDespacho")
	private Despacho despacho;
	
	public SolicitudDespacho() {
	
	}

	public int getNroSolicitudDespacho() {
		return nroSolicitudDespacho;
	}

	public void getNroSolicitudDespacho(int nroSolicitudDespacho) {
		this.nroSolicitudDespacho = nroSolicitudDespacho;
	}

	public List<ItemSolicitudDespacho> getItems() {
		return items;
	}

	public void setItems(List<ItemSolicitudDespacho> items) {
		this.items = items;
	}

	public String getEstado (){
		return this.estado;
	}
	
	public void setEstado (String estado){
		this.estado=estado;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
