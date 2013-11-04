package entity.vo;

import java.util.List;

import entity.ItemSolicitudCompra;

public class SolicitudCompraVO {
	
	private int nroSolicitudCompra;
	private List<ItemSolicitudCompraVO> items;
	private String estado;
	private float total;
	private FabricaVO fabrica;
	
	public SolicitudCompraVO(int nroSolicitudCompra,
			List<ItemSolicitudCompraVO> items, String estado, float total,
			FabricaVO fabrica) {
		this.nroSolicitudCompra = nroSolicitudCompra;
		this.items = items;
		this.estado = estado;
		this.total = total;
		this.fabrica = fabrica;
	}
	
	public int getNroSolicitudCompra() {
		return nroSolicitudCompra;
	}
	public void setNroSolicitudCompra(int nroSolicitudCompra) {
		this.nroSolicitudCompra = nroSolicitudCompra;
	}
	public List<ItemSolicitudCompraVO> getItems() {
		return items;
	}
	public void setItems(List<ItemSolicitudCompraVO> items) {
		this.items = items;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public FabricaVO getFabrica() {
		return fabrica;
	}
	public void setFabrica(FabricaVO fabrica) {
		this.fabrica = fabrica;
	}

	
	
}
