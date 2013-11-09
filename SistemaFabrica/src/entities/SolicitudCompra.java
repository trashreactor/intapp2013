package entities;

import java.util.ArrayList;
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
import javax.xml.bind.annotation.*;

@Entity
@Table(name="SolicitudCompra")
@XmlRootElement(name = "SolicitudCompra")
@XmlAccessorType (XmlAccessType.FIELD)
public class SolicitudCompra {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute(name = "NroSolicitud")
	private int nroSolicitudCompra;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "nroSolicitudCompra")
	@XmlElement(name = "ItemSolicitud")
	private List<ItemSolicitudCompra> items;
	
	@XmlAttribute(name = "Estado")
	private String estado;
	
	@XmlAttribute(name = "Total")
	private float total;
	
	@OneToOne
	@JoinColumn(name="idFabrica")
	private Fabrica fabrica;

	public SolicitudCompra() {
		items = new ArrayList<ItemSolicitudCompra>();
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
	
	public void addItem(ItemSolicitudCompra item){
		items.add(item);
	}
}
