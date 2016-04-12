package es.uniovi.asw.dbupdate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public class ElectoralCollege {
	
	private Long id;
	private String codigo;
	
	protected ElectoralCollege(){
		
	}
	
	public ElectoralCollege(String codigo){
		this.codigo=codigo;
	}

	public String getCodigoColegio() {
		return codigo;
	}
}
