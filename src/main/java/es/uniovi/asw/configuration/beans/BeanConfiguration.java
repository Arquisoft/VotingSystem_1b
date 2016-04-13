package es.uniovi.asw.configuration.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.configuration.business.ConfigService;
import es.uniovi.asw.configuration.business.impl.SimpleConfigService;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;

@Component
public class BeanConfiguration extends ConfigurationElection implements Serializable {
	public BeanConfiguration() {
		super();
	}

	private static final long serialVersionUID = 6L;
	
	public String configura() {
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleConfigService service = ctx.getBean(SimpleConfigService.class);
		FacesContext fc = FacesContext.getCurrentInstance();		
		try {
			service.saveConfiguration(getConfigurationElection());
			fc.addMessage("laInfo", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se ha guardado su configuración."));
			} catch (Exception e) {
				fc.addMessage("elError", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar la configuración"));
				return null;
				}
		
		return null;
		}
}
	