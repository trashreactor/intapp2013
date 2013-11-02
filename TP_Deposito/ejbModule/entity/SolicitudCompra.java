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
@Table(name="SolicitudCompra")

public class SolicitudCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroSolicitudCompra;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nroSolicitudCompra")
	private List<ItemSolicitudCompra> items;
	
	private String estado;
	
	private float total;
	
	@OneToOne
	@JoinColumn(name="idFabrica")
	private Fabrica fabrica;

	public SolicitudCompra() {
	
	}

	public int getNroSolicitudCompra() {
		return nroSolicitudCompra;
	}

	public void setNroSolicitudCompra(int nroSolicitudCompra) {
		this.nroSolicitudCompra = nroSolicitudCompra;
	}

	public List<ItemSolicitudCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemSolicitudCompra> items) {
		this.items = items;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
