package entity.vo;


public class ItemSolicitudCompraVO {

	private int nroItemSolicitudCompra;
	private ArticuloVO articulo;
	private int cantidad;
	
	public ItemSolicitudCompraVO(int nroItemSolicitudCompra,
			ArticuloVO articulo, int cantidad) {
		this.nroItemSolicitudCompra = nroItemSolicitudCompra;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	public int getNroItemSolicitudCompra() {
		return nroItemSolicitudCompra;
	}
	public void setNroItemSolicitudCompra(int nroItemSolicitudCompra) {
		this.nroItemSolicitudCompra = nroItemSolicitudCompra;
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
	
	
		
		
		
	

}
