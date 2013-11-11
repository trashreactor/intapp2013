package entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity @Table(name = "Articulo")
@XmlRootElement(name = "Articulo") @XmlAccessorType(XmlAccessType.FIELD)
public class Articulo implements Serializable{
	
	private static final long serialVersionUID = 1059951037454272340L;
	
	@XmlAttribute(name = "CodArticulo")
	@Id @Column(name = "CodArticulo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codArticulo;
	
	public Articulo(){}

	public int getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
}
