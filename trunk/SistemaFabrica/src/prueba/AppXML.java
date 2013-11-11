package prueba;

import java.io.File;

import javax.xml.bind.*;

import entities.*;

public class AppXML {
	public static void main(String[] args) throws JAXBException 
	{
	    JAXBContext jaxbContext = JAXBContext.newInstance(SolicitudCompra.class);
	    Marshaller mar = jaxbContext.createMarshaller();
	    
	    SolicitudCompra solicitud = new SolicitudCompra();
	    solicitud.setNroSolicitudCompra(1);
	    Articulo articulo1 = new Articulo();
	    articulo1.setCodArticulo(1);
	    ItemSolicitudCompra item1 = new ItemSolicitudCompra();
	    item1.setArticulo(articulo1);
	    solicitud.addItem(item1);
	     
	    //We had written this file in marshalling example
	    File archivo = new File("SolicitudPrueba.xml");
	    mar.marshal(solicitud, archivo);
	    
	    
//	    solicitud = (SolicitudCompra) jaxbUnmarshaller.unmarshal(new File("Productos.xml"));
//	     
//	    for(Producto p : lista.getListaProductos())
//	    {
//	        System.out.println(p.getDescripcion());
//	        System.out.println(p.getPrecio());
//	    }
	}
}
