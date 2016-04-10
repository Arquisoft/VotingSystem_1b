package es.uniovi.asw.dbupdate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public class Colegio {
	private Long id;
	private String codigo;
	
	protected Colegio(){
		
	}
	
	public Colegio(String codigo){
		this.codigo=codigo;
	}

	public String getCodigoColegio() {
		return codigo;
	}
}
