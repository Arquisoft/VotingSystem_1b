package es.uniovi.asw.dbupdate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;

@Repository
public interface VotableOptionDAO  extends CrudRepository<VotableOption, Long> { 

	  
}
