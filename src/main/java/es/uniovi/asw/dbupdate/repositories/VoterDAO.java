package es.uniovi.asw.dbupdate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.Voter;


@Repository
public interface VoterDAO  extends CrudRepository<Voter, Long> { 

	   // public List<Voter> findByNombre(String nombre);
	
}
