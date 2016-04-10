package es.uniovi.asw.dbupdate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VOTO")
public class Vote {

		private Long id;
		private Date fecha;
		private String codigoColegio;
		private OpcionVoto opcion;
		
		protected Vote(){
			
		}
		
		public Vote(Date fecha, String codigoColegio, OpcionVoto opcion){
			this.fecha=fecha;
			this.codigoColegio=codigoColegio;
			this.opcion=opcion;
		}

		public Date getFecha() {
			return fecha;
		}
		
		public String getCodigoColegio() {
			return codigoColegio;
		}

		public OpcionVoto getOpcion() {
			return opcion;
		}
		
	}
