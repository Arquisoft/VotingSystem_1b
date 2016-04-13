package es.uniovi.asw.configuration.business.impl.classes;

import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;

public class ConfigurationSave {

	public void save(ConfigurationElection config) throws PersistenceException {
		//
		try{
			System.out.println("GUARDANDO LA CONFIGURACIÓN");
			//dao.save(config);
		}catch(PersistenceException e){
			throw new PersistenceException("Error al crear la configuración",e);
		}
		
	}

}
