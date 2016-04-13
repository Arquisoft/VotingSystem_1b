package es.uniovi.asw.voter.application.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.voter.application.bussiness.impl.SimpleApplicationService;
import es.uniovi.asw.voter.application.exception.InvalidUserException;

@Component
public class BeanApplication {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String apply(ConfigurationElection configurationElection){
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleApplicationService sas = ctx.getBean(SimpleApplicationService.class);
		
		try {
			sas.saveApplication(email, password, configurationElection);
		} catch (InvalidUserException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Correo electronico y/o contraseña incorrectos");
            FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Voto telematico admitido");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
		return null;
	}

}
