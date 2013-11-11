package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

@Entity
@Table(name="ItemSolicitudCompra")
@XmlRootElement(name = "ItemSolicitud")
@XmlAccessorType (XmlAccessType.FIELD)
public class ItemSolicitudCompra implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NroItem")
	@XmlAttribute(name = "NroItem")
	private int nroItemSolicitudCompra;
		
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CodArticulo")
	@XmlElement(name = "Articulo")
	private Articulo articulo;
	
	@XmlElement(name = "Cantidad")
	@Column(name = "Cantidad")
	private int cantidad;

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="NroSolicitudCompra")
//	private SolicitudCompra solicitudCompra;
	
	public ItemSolicitudCompra() {}

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
	
//	public SolicitudCompra getSolicitudCompra (){
//		return this.solicitudCompra;
//	}
//	
//	public void setSolicitudCompra (SolicitudCompra solicitudCompra){
//		this.solicitudCompra=solicitudCompra;
//	}
	
	
	
	

}
