package es.uniovi.asw.configuration.business.impl;

import es.uniovi.asw.configuration.business.ConfigService;
import es.uniovi.asw.configuration.business.ServicesFactory;


public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public ConfigService createConfigService() {
		return new SimpleConfigService();
	}

}
