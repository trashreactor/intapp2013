package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ItemRemitoCompra")

public class ItemRemitoCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroItemRemitoCompra;
		
	@OneToOne
	@JoinColumn(name="codArticulo")
	private Articulo articulo;
	
	private int cantidad;

	@ManyToOne(cascade={})
	@JoinColumn(name="nroRemitoCompra")
	private RemitoCompra remitoCompra;
	
	public ItemRemitoCompra() {
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
