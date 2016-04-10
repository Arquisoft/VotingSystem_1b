package es.uniovi.asw.configuration.business.impl;



import es.uniovi.asw.configuration.business.ConfigService;
import es.uniovi.asw.configuration.business.impl.classes.ConfigurationSave;
import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.Configuration;

public class SimpleConfigService implements ConfigService {

	@Override
	public void saveConfiguration(Configuration config)throws PersistenceException {
		new ConfigurationSave().save(config);
		
	}

}
