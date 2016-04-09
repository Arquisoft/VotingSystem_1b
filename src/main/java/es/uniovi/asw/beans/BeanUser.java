package es.uniovi.asw.beans;

import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import es.uniovi.asw.dbupdate.exception.NotPersistedException;
import es.uniovi.asw.dbupdate.model.User;

@ManagedBean(name = "user")
@SessionScoped 
public class BeanUser extends User implements Serializable {
	private static final long serialVersionUID = 6L;
	
	public String verify() throws NotPersistedException {
//		UserService us = Factories.services.createUserService();
//		User user = us.verify(getLogin(), getPassword());
		FacesContext fc = FacesContext.getCurrentInstance();	
		User user = null;
		if (user != null) {    
			putUserInSession(user);
			fc.addMessage("laInfo", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Ha iniciado sesión correctamente."));
			return "exito";   
			}   
		fc.addMessage("elError", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Los datos introducidos son incorrectos"));
		return "fallo";  
		}
	
	private void putUserInSession(User user) {   
		Map<String, Object> session = FacesContext 
				.getCurrentInstance()     
				.getExternalContext()     
				.getSessionMap();      
		session.put("LOGGEDIN_USER", user); 
		}   
}
	