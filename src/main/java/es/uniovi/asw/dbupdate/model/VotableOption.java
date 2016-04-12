package es.uniovi.asw.dbupdate.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class VotableOption {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String descripcion;
//	@ManyToOne
//	private ConfigurationElection configurationElection;
	
	VotableOption() { }
	
	public VotableOption(String nombre, String descripcion,
			ConfigurationElection configurationElection) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
//		this.configurationElection = configurationElection;
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

//	public ConfigurationElection getConfigurationElection() {
//		return configurationElection;
//	}
//
//	public void setConfigurationElection(ConfigurationElection configurationElection) {
//		this.configurationElection = configurationElection;
//	}
	
}
