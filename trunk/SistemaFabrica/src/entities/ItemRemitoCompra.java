package entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name="ItemRemitoCompra")
@XmlRootElement(name = "ItemRemito")
@XmlAccessorType (XmlAccessType.FIELD)
public class ItemRemitoCompra implements Serializable{
	
	private static final long serialVersionUID = -1348698855638814644L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute(name = "Numero")
	private int nroItemRemitoCompra;
		
	@OneToOne @JoinColumn(name="codArticulo")
	@XmlElement(name = "Articulo")
	private Articulo articulo;
	
	@XmlAttribute(name = "Cantidad")
	private int cantidad;

	@ManyToOne(cascade={}) @JoinColumn(name="nroRemitoCompra")
	@XmlTransient
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
