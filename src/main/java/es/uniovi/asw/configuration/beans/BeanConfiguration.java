package es.uniovi.asw.configuration.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import es.uniovi.asw.configuration.business.ConfigService;
import es.uniovi.asw.configuration.business.impl.SimpleServicesFactory;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;

//@ManagedBean(name = "configuration")
//public class BeanConfiguration extends ConfigurationElection implements Serializable {
//	private static final long serialVersionUID = 6L;
//	
//	public String configura() {
//		ConfigService service = new SimpleServicesFactory().createConfigService();
//		FacesContext fc = FacesContext.getCurrentInstance();		
//		try {
//			service.saveConfiguration(this);
//			fc.addMessage("laInfo", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se ha guardado su configuración."));
//			return "exito";
//			} catch (Exception e) {
//				fc.addMessage("elError", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar la configuración"));
//				return "error";
//				}
//		}
//}
	