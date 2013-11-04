package facade;

import java.util.*;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import entities.*;

@Path("/")
@Remote
public interface SistemaFabrica{
	
	//POR ESTE METODO SE CARGAN LAS SOLICITUDES A FABRICA//
	//SE SUBE EL JSON POR POST DESDE LA INTERFAZ WEB ?   //
	@POST @Path("enviarSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	public void enviarSolicitud(SolicitudCompra solicitud);
	//--------------------------------------------------//
	
	//ESTE METODO ENTREGA LAS SOLICITUDES QUE TIENE CARGADAS LA FABRICA//
	@GET @Path("solicitudes")
	public List<SolicitudCompra> obtenerSolicitudes();
	//-----------------------------------------------------------------//
	
	@GET @Path("confirmar")
	public void confirmarSolicitudes(List<Integer> nrosSolicitudes) throws Exception;
}
