package entity.vo;



public class ArtNinosVO {

	private int id;
	private String nombre;
	private String descripcion;
	private float precio;
	private String foto;
	private int stock;
	private String rangoEdad;
	
	public ArtNinosVO(int id, String nombre, String descripcion,
			float precio, String foto, int stock, String rangoEdad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
		this.stock = stock;
		this.rangoEdad = rangoEdad;
	}
	
	public ArtNinosVO(String nombre, String descripcion, float precio,
			String foto, int stock, String rangoEdad) {
		super();
	
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.foto = foto;
		this.stock = stock;
		this.rangoEdad = rangoEdad;
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
	public String getRangoEdad() {
		return rangoEdad;
	}
	public void setRangoEdad(String rangoEdad) {
		this.rangoEdad = rangoEdad;
	}
	
	
	
	

}
