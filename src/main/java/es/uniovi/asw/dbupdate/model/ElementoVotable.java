package es.uniovi.asw.dbupdate.model;

public class ElementoVotable {
	
	
	private String nombre;
	private String descripcion;
	//todo lo que se quiera decir sobre la opcion de voto?
	
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
	public ElementoVotable(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	

}
