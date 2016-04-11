package es.uniovi.asw.dbupdate.model;

public class Eleccion {

	//identificador de la eleccion es Config ID
	//Tambien deberian ser unicos el nombre, la fecha de inicio
		
		
		private String nombreEleccion;
		public String getNombreEleccion() {
			return nombreEleccion;
		}
		public void setNombreEleccion(String nombreEleccion) {
			this.nombreEleccion = nombreEleccion;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public Configuration getConfig() {
			return config;
		}
		public void setConfig(Configuration config) {
			this.config = config;
		}
		private String descripcion;
		private Configuration config;
		public Eleccion(String nombreEleccion, String descripcion,
				Configuration config) {
			super();
			this.nombreEleccion = nombreEleccion;
			this.descripcion = descripcion;
			this.config = config;
		}
		
		
		

}
