package es.uniovi.asw.dbupdate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;


@Repository
public interface ConfigurationDAO  extends CrudRepository<ConfigurationElection, Long> { 
	
}
