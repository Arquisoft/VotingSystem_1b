package es.uniovi.asw.voteApplication.presentation;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="voteApplication")
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
		System.out.println(email + "·" + password);
		return null;
	}

}
