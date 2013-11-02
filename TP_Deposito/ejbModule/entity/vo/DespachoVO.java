package entity.vo;


public class DespachoVO {

	private int idDespacho;
	private String descripcion;
	public String ip;
			

	public DespachoVO(int idDespacho, String descripcion) {
		this.idDespacho = idDespacho;
		this.descripcion = descripcion;
	}

	public void setIdDespacho (int id){
		this.idDespacho=id;
	}
	
	public int getIdDespacho(){
		return idDespacho;
	}
	

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}

}
