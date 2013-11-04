package entity.vo;



public class ItemSolicitudDespachoVO {

	private int nroItemSolicitudDespacho;
	private ArticuloVO articulo;
	private int cantidad;
	private SolicitudDespachoVO solicitudDespacho;
	
	
	
	public ItemSolicitudDespachoVO(int nroItemSolicitudDespacho,
			ArticuloVO articulo, int cantidad,
			SolicitudDespachoVO solicitudDespacho) {
		this.nroItemSolicitudDespacho = nroItemSolicitudDespacho;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.solicitudDespacho = solicitudDespacho;
	}
	public int getNroItemSolicitudDespacho() {
		return nroItemSolicitudDespacho;
	}
	public void setNroItemSolicitudDespacho(int nroItemSolicitudDespacho) {
		this.nroItemSolicitudDespacho = nroItemSolicitudDespacho;
	}
	public ArticuloVO getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public SolicitudDespachoVO getSolicitudDespacho() {
		return solicitudDespacho;
	}
	public void setSolicitudDespacho(SolicitudDespachoVO solicitudDespacho) {
		this.solicitudDespacho = solicitudDespacho;
	}
	
	
	


}
