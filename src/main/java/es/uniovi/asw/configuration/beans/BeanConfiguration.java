package es.uniovi.asw.configuration.beans;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import es.uniovi.asw.configuration.business.ConfigService;
import es.uniovi.asw.dbupdate.model.Configuration;
import es.uniovi.asw.dbupdate.model.User;

@ManagedBean(name = "configuration")
@ApplicationScoped
public class BeanConfiguration extends Configuration implements Serializable {
	private static final long serialVersionUID = 6L;
	
	public String configura() {
		ConfigService service;
		FacesContext fc = FacesContext.getCurrentInstance();		
		try {
			/*service = ServicesFactor;
			service.saveConfiguration(this);*/
			fc.addMessage("aparte", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se ha guardado su configuración."));
			return "exito";
			} catch (Exception e) {
				fc.addMessage("muestrame", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar la configuración"));
				return "error";
				}
		}
	
	private void putUserInSession(User user) {   
		Map<String, Object> session = FacesContext 
				.getCurrentInstance()     
				.getExternalContext()     
				.getSessionMap();      
		session.put("LOGGEDIN_USER", user); 
		}   
}
	