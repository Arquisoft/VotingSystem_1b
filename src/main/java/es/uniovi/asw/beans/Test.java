package es.uniovi.asw.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Test {
	public String getHello() {
		return "Hello from PrimeFaces and Spring Boot!";
	}
}