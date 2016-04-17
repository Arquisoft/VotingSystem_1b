package es.uniovi.asw.configuration.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.configuration.business.impl.SimpleConfigService;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.VotableOption;

@Component
public class BeanConfiguration extends ConfigurationElection implements Serializable {
	public BeanConfiguration() {
		super();
	}

	private static final long serialVersionUID = 6L;
	private int numOptions;
	
	public int getNumOptions() {
		return numOptions;
	}

	public void setNumOptions(int numOptions) {
		this.numOptions = numOptions;
	}

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
	
	public String opcionesVoto() {
		for(int i = 0; i<numOptions; i++){			
			getVotableOptions().add(new VotableOption("","",this));
		}
		return null;		
	}
}
	