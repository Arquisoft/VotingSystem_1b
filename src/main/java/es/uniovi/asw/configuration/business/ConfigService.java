package es.uniovi.asw.configuration.business;

import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.Configuration;

public interface ConfigService {

	void saveConfiguration(Configuration config) throws PersistenceException;
}
