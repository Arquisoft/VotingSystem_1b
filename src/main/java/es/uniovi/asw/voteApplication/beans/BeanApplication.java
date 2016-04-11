package es.uniovi.asw.voteApplication.beans;

import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import es.uniovi.asw.voteApplication.bussiness.impl.SimpleApplicationService;

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
	
	public String apply(){
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		SimpleApplicationService sas = ctx.getBean(SimpleApplicationService.class);
		
		System.out.println(email + "·" + password);
		sas.saveApplication(email, password);
		return null;
	}

}
