package es.uniovi.asw.dbupdate.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONFIGURACION")
public class ConfigurationElection {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombreEleccion;
	private String descripcion;
	private Date horaInicio;
	private Date horaFin;
	//private List<ElementoVotable> opcionesVoto;

	//List<Colegio> colegios;
	private boolean votoMultiple;
	
	protected ConfigurationElection(){
		
	}
	
	public ConfigurationElection(String nombre, String descripcion, Date horaInicio, Date horaFin, List<String> opciones, List<ElectoralCollege> colegios, List<VotableOption> opcionesVoto, boolean votoMultiple){
		this.nombreEleccion=nombre;
		this.descripcion=descripcion;
		this.setHoraInicio(horaInicio);
		this.setHoraFin(horaFin);
		//this.opcionesVoto=opcionesVoto;
		//this.opciones=opciones;
		//this.colegios=colegios;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
		
	}
