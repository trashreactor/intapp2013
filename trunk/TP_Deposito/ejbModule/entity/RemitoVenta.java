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
@Table(name="RemitoVenta")

public class RemitoVenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroRemitoVenta;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nroRemitoVenta")
	private List<ItemRemitoVenta> items;
	
	private float total;
	
	private boolean confirmado;

	@OneToOne
	@JoinColumn(name="idDespacho")
	private Despacho despacho;
	
	public RemitoVenta() {
	
	}

	public int getNroRemitoVenta() {
		return nroRemitoVenta;
	}

	public void setNroRemitoVenta(int nroRemitoVenta) {
		this.nroRemitoVenta = nroRemitoVenta;
	}

	public List<ItemRemitoVenta> getItems() {
		return items;
	}

	public void setItems(List<ItemRemitoVenta> items) {
		this.items = items;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
