package entity.vo;

import java.util.List;

public class SolicitudDespachoVO {
	private int nroSolicitudDespacho;
	private List<ItemSolicitudDespachoVO> items;
	private String estado;
	private float total;
	private DespachoVO despacho;
	
	public SolicitudDespachoVO(int nroSolicitudDespacho,
			List<ItemSolicitudDespachoVO> items, String estado, float total,
			DespachoVO despacho) {
		this.nroSolicitudDespacho = nroSolicitudDespacho;
		this.items = items;
		this.estado = estado;
		this.total = total;
		this.despacho = despacho;
	}

	public int getNroSolicitudDespacho() {
		return nroSolicitudDespacho;
	}

	public void setNroSolicitudDespacho(int nroSolicitudDespacho) {
		this.nroSolicitudDespacho = nroSolicitudDespacho;
	}

	public List<ItemSolicitudDespachoVO> getItems() {
		return items;
	}

	public void setItems(List<ItemSolicitudDespachoVO> items) {
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

	public DespachoVO getDespacho() {
		return despacho;
	}

	public void setDespacho(DespachoVO despacho) {
		this.despacho = despacho;
	}
	
	

	
	
	

}
