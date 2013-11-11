package prueba;

import java.io.*;

import javax.xml.bind.*;

import entities.*;

public class LeerXML {
	public static void main(String[] args) throws JAXBException 
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(SolicitudCompra.class);
		Unmarshaller unm = jaxbContext.createUnmarshaller();
		
		File archivoXML = new File("Solicitud.xml");
		SolicitudCompra solicitud = (SolicitudCompra) unm.unmarshal(archivoXML);
		
		PrintStream p = System.out;
		p.println("Solicitud: " + solicitud.getNroSolicitudCompra());
		for(ItemSolicitudCompra i: solicitud.getItems()){
			p.println("	Articulo: " + i.getArticulo().getCodArticulo());
			p.println("	Cantidad: " + i.getCantidad());
		}
	}
}
