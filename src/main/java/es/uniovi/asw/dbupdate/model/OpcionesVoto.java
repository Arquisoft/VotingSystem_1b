package es.uniovi.asw.dbupdate.model;

import java.util.HashMap;
import java.util.Map;

public class OpcionesVoto {
	
	private Map<Vote, Integer> votos;
	
	public void addVoto(Vote v, int cantidad){
		//La cantidad sera 1 para el usuario por defecto y el indicado en cantidad por la junta electoral
		votos.put(v, cantidad);
	}

	public OpcionesVoto() {
		votos=new HashMap<Vote, Integer>();
	}
	
	

}
