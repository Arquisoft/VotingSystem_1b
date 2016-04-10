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


		private Long id;
		private Date horaInicio;
		private Date horaFin;
		List<String> opciones;
		List<Colegio> colegios;
		private boolean multiple;
		List<ElementoVotable> posiblesVotantes;
		
		protected Configuration(){
			
		}
		
		public Configuration(Date horaInicio, Date horaFin, List<String> opciones, List<Colegio> colegios, boolean mltiple
				, List<ElementoVotable> posiblesVotantes){
			this.horaInicio=horaInicio;
			this.horaFin=horaFin;
			this.opciones=opciones;
			this.colegios=colegios;
			this.multiple=mltiple;
			this.posiblesVotantes=posiblesVotantes;
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
