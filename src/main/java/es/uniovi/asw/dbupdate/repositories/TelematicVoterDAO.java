package es.uniovi.asw.dbupdate.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.dbupdate.model.TelematicVoter;

@Repository
public interface TelematicVoterDAO extends CrudRepository<TelematicVoter, Long>{

}
