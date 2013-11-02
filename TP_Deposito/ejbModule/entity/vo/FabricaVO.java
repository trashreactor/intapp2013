package entity.vo;


public class FabricaVO {

	private int idFabrica;
	private String descripcion;
	private String ip;
	
	
	public FabricaVO(int idFabrica, String descripcion, String ip) {
		super();
		this.idFabrica = idFabrica;
		this.descripcion = descripcion;
		this.ip = ip;
	}

	public void setIdFabrica(int idFabrica){
		this.idFabrica=idFabrica;
	}
	
	public int getIdFabrica(){
		return idFabrica;
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
