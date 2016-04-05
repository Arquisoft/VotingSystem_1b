package es.uniovi.asw.dbupdate.dto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.dbupdate.model.Voter;

public interface VoterRepository  extends CrudRepository<Voter, Long> { 



	    List<Voter> findByNombre(String nombre);
	
}
