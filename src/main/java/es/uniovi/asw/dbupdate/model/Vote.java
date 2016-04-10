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

<<<<<<< HEAD
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
=======
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date fecha;
	private String codigoColegio;
	private String opcion;
	
	protected Vote(){
		
	}
	
	public Vote(Date fecha, String codigoColegio, String opcion){
		this.fecha=fecha;
		this.codigoColegio=codigoColegio;
		this.opcion=opcion;
	}
>>>>>>> refs/remotes/origin/master

	public Date getFecha() {
		return fecha;
	}
	
	public String getCodigoColegio() {
		return codigoColegio;
	}

<<<<<<< HEAD
		public OpcionVoto getOpcion() {
			return opcion;
		}
=======
	public String getOpcion() {
		return opcion;
	}
>>>>>>> refs/remotes/origin/master
		
	}
