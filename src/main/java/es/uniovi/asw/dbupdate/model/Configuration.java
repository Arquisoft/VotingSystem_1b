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
public class Configuration {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date horaInicio;
	private Date horaFin;
	//List<String> opciones;
	//List<Colegio> colegios;
	//Tipo de elecciones?
	
	protected Configuration(){
		
	}
	
	public Configuration(Date horaInicio, Date horaFin, List<String> opciones, List<Colegio> colegios){
		this.setHoraInicio(horaInicio);
		this.setHoraFin(horaFin);
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
