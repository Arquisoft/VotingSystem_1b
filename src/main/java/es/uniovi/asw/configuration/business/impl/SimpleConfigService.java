package es.uniovi.asw.configuration.business.impl;



import es.uniovi.asw.configuration.business.ConfigService;
import es.uniovi.asw.configuration.business.impl.classes.ConfigurationSave;
import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;

public class SimpleConfigService implements ConfigService {

	@Override
	public void saveConfiguration(ConfigurationElection config)throws PersistenceException {
		new ConfigurationSave().save(config);
		
	}

}
