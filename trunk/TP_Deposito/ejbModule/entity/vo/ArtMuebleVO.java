package entity.vo;


public class ArtMuebleVO {
	private int id;
	private String nombre;
	private String descripcion;
	private float precio;
	private String foto;
	private int stock;
	private String material;
	private String marca;
	private String origen;
	
	public ArtMuebleVO(int id,String nombre, String descripcion,
			float precio, String foto, int stock, String material,String marca, String origen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
		this.stock = stock;
		this.material = material;
		this.marca = marca;
		this.origen = origen;
		
	}
	public ArtMuebleVO(String nombre, String descripcion, float precio,
			String foto, int stock, String material) {
		super();
	
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
		this.stock = stock;
		this.material = material;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	
	
	

}
