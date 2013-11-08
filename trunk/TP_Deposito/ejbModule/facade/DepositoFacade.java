package facade;

import java.util.List;

import javax.ejb.Remote;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import xml.*;
import entity.*;
import entity.vo.*;


@Path("/")
@Remote
public interface DepositoFacade extends MessageListener{
	
	
	//articulo
	public List<ArticuloVO> getAllArticulos ();
	public ArticuloVO getArticulo (int id);
	
	
	
	//=================================================
	//ADMINISTRAR PRODUCTOS
	
	@POST @Path("crearElectro")
	@Consumes(MediaType.APPLICATION_XML)
	public void crearArticuloElectro(ArtElectroVO electro);
	
	@POST @Path("crearModa")
	@Consumes(MediaType.APPLICATION_XML)
	public void crearArticuloModa(ArtModaVO moda);
	
	@POST @Path("crearMueble")
	@Consumes(MediaType.APPLICATION_XML)
	public void crearArticuloElectro(ArtMuebleVO mueble);
	
	@POST @Path("crearNinos")
	@Consumes(MediaType.APPLICATION_XML)
	public void crearArticuloElectro(ArtNinosVO ninos);
	
	@GET @Path("buscarArticulo/{descripcion}")
	public ArticuloVO buscarArticulo(@PathParam("descripcion") String descripcion);
	
	@GET @Path("modificarArticulo/{codArticulo}&{nuevoStock}")
	public void modificarStock(@PathParam("codArticulo") int codArticulo, @PathParam("nuevoStock") int nuevoStock);
	
	@POST @Path("sumarStock")
	@Consumes(MediaType.APPLICATION_XML)
	public void sumarStock(ArticuloVO artVO);
	
	//===================================================
	//RECEPCION SOLICITUD ARTICULOS
	
	public void onMessage(Message message);
	
	//==================================================
	//CREAR SOLICITUD DE COMPRA
	
	@GET @Path("solicitudesCompraPendientes")
	@Produces(MediaType.APPLICATION_XML)
	public List<SolicitudCompraVO> getSolicitudesCompraPendientes();
	//No estoy seguro de esta, ¿como se van a presentar las solicitudes en la pagina?
	
	@POST @Path("crearSolicitudCompra")
	@Consumes(MediaType.APPLICATION_XML)
	public void crearSolicitudCompra(SolicitudCompra solicitud);
	
	//=====================================================================
	//CREAR REMITO DE VENTA
	
	@GET @Path("solicitudesDespachoPendientes")
	@Produces(MediaType.APPLICATION_XML)
	public List<SolicitudDespachoVO> getSolicitudesDespachoPendientes();
	
	@POST @Path("crearRemitoVenta")
	@Consumes(MediaType.APPLICATION_XML)
	public void confirmarSolicitudes(ConfirmarSolicitudesXML confirmacion);
	//=======================================================================
}