package entities;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "RemitoCompra")
@XmlRootElement(name = "RemitoCompra")
@XmlAccessorType (XmlAccessType.FIELD)
public class RemitoCompra implements Serializable{
	
	private static final long serialVersionUID = 4167598581551008212L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute(name = "Numero")
	private int nroRemitoCompra;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="nroRemitoCompra")
	@XmlElement(name = "ItemRemito")
	private List<ItemRemitoCompra> items;
	
	@XmlTransient
	private float total;
	
	@XmlAttribute(name = "Confirmado")
	private boolean confirmado;
	
	@OneToOne
	@JoinColumn(name="idFabrica")
	private Fabrica fabrica;
	
	public RemitoCompra() {
		items = new ArrayList<ItemRemitoCompra>();
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
	
	public void addItem(ItemRemitoCompra item){
		items.add(item);
	}
}
