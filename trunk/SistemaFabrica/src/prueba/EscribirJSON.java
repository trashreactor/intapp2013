package prueba;

import entities.Articulo;
import entities.ItemSolicitudCompra;
import entities.SolicitudCompra;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EscribirJSON {
	public static void main(String[] args) {
		 SolicitudCompra solicitud = new SolicitudCompra();
//		 solicitud.setNroSolicitudCompra(1);
		    Articulo articulo1 = new Articulo();
//		    articulo1.setCodArticulo(1);
		    ItemSolicitudCompra item1 = new ItemSolicitudCompra();
		    item1.setCantidad(10);
		    item1.setArticulo(articulo1);
		    solicitud.addItem(item1);
		    Articulo articulo2 = new Articulo();
//		    articulo2.setCodArticulo(2);
		    ItemSolicitudCompra item2 = new ItemSolicitudCompra();
		    item2.setCantidad(15);
		    item2.setArticulo(articulo2);
		    solicitud.addItem(item2);
		
		ObjectMapper mapper = new ObjectMapper();
		
	 
		try {
	 
			// convert user object to json string, and save to a file
			mapper.writeValue(new File("SolicitudPrueba.json"), solicitud);
	 
			// display to console
			System.out.println(mapper.writeValueAsString(solicitud));
	 
		} catch (JsonGenerationException e) {
	 
			e.printStackTrace();
	 
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
	 
		} catch (IOException e) {
	 
			e.printStackTrace();
	 
		}
	}
}
