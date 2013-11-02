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
@Table(name="RemitoCompra")

public class RemitoCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroRemitoCompra;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nroRemitoCompra")
	private List<ItemRemitoCompra> items;
	
	private float total;
	
	private boolean confirmado;
	
	@OneToOne
	@JoinColumn(name="idFabrica")
	private Fabrica fabrica;
	
	public RemitoCompra() {
	
	}

	public int getNroRemitoCompra() {
		return nroRemitoCompra;
	}

	public void setNroRemitoCompra(int nroRemitoCompra) {
		this.nroRemitoCompra = nroRemitoCompra;
	}

	public List<ItemRemitoCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemRemitoCompra> items) {
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
