package es.uniovi.asw.configuration.business.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.configuration.business.ConfigService;
import es.uniovi.asw.dbupdate.exception.PersistenceException;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;

@Component
public class SimpleConfigService implements ConfigService {

	@Autowired(required=true)
	private ConfigurationDAO dao;
	
	@Override
	public void saveConfiguration(ConfigurationElection config)throws PersistenceException {
		try{
			System.out.println("GUARDANDO LA CONFIGURACIÓN");//Borrar
			dao.save(config);
			System.out.println("GUARDADO");//Borrar
		}catch(PersistenceException e){
			throw new PersistenceException("Error al crear la configuración",e);
		}
		
	}

}
