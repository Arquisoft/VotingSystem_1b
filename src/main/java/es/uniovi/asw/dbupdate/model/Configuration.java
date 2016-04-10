package es.uniovi.asw.dbupdate.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Configuration {


	private Long id;
	private Date horaInicio;
	private Date horaFin;
	//private Set<ElementoVotable> opcionesVoto;

	//List<Colegio> colegios;
	//private boolean votoMultiple;
	
	protected Configuration(){
		
	}
	
	public Configuration(Date horaInicio, Date horaFin, List<String> opciones, Set<ElementoVotable> opcionesVoto, boolean votoMultiple){
		this.setHoraInicio(horaInicio);
		this.setHoraFin(horaFin);
		//this.votoMultiple=votoMultiple;
		//this.opcionesVoto=opcionesVoto;
	
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
