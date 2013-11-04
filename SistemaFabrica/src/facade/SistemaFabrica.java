package facade;

import java.util.*;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import entities.*;

@Path("/")
@Remote
public interface SistemaFabrica{
	@POST @Path("enviarSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	public void enviarSolicitud(SolicitudCompra solicitud);
	
	@GET @Path("solicitudes")
	public List<SolicitudCompra> obtenerSolicitudes();
}
