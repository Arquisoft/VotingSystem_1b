package es.uniovi.asw.dbupdate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.Configuration;


//@Repository TODO cambiar esto
public interface ConfigurationDAO  extends CrudRepository<Configuration, Long> { 
	
}
