package xml;

import java.util.*;
import javax.xml.bind.annotation.*;

//ARCHIVO XML AUXILIAR PARA CONFIRMAR LAS SOLICITUDES A MANDAR A DESPACHO//
//Capaz es al pedo, si ya habian pensado otra forma para hacerlo me dicen.//

@XmlRootElement(name = "Solicitud")
@XmlAccessorType (XmlAccessType.FIELD)
public class ConfirmarSolicitudesXML {
	@XmlElement(name = "Item")
	private List<ItemSolicitudXML> items;
	
	public ConfirmarSolicitudesXML(){
		items = new ArrayList<ItemSolicitudXML>();
	}

	public List<ItemSolicitudXML> getItems() {
		return items;
	}

	public void setItems(List<ItemSolicitudXML> items) {
		this.items = items;
	}
	
	public void addItem(ItemSolicitudXML item){
		this.items.add(item);
	}
}
