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
@Table(name="ItemRemitoVenta")
public class ItemRemitoVenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroItemRemitoVenta;
		
	@OneToOne
	@JoinColumn(name="codArticulo")
	private Articulo articulo;
	
	private int cantidad;

	@ManyToOne(cascade={})
	@JoinColumn(name="nroRemitoVenta")
	private RemitoVenta remitoVenta;
	
	public ItemRemitoVenta() {
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
