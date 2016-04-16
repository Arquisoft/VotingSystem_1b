package es.uniovi.asw.steps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import es.uniovi.asw.CucumberTest;
import es.uniovi.asw.Main;
import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.ElectoralCollege;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.util.SeleniumUtils;

@ContextConfiguration(classes=Main.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class VoteApplication {

	private WebDriver driver = CucumberTest.getDriver("VoteApplication");
	
	@Autowired
	UserDAO ud;
	@Autowired
	ConfigurationDAO cd;

	private static boolean setUpIsDone = false;

	@SuppressWarnings("deprecation")
	@Before
	public void startBD(){
		if(!setUpIsDone){

			List<VotableOption> listaOptiones = new ArrayList<>();
			List<ElectoralCollege> listaColegios = new ArrayList<>();
			
			Date fecha = new Date();
			fecha.setMonth(fecha.getMonth() - 1);
			Date applycationStart = new Date(fecha.getTime());
			fecha.setMonth(fecha.getMonth() + 2);
			Date applycationEnd = new Date(fecha.getTime());
			
			ConfigurationElection c = new ConfigurationElection("Prueba votacion",
					"Probando", applycationStart, applycationEnd, new Date(), new Date(), listaOptiones,
					listaColegios, false);
			
			cd.save(c);
			
			User user = new User("Pepe", "pepe@gmail.com", "74321123N", "321");
			user.setContrasena("12345");

			ud.save(user);
			setUpIsDone = true;
		}
	}

	@Cuando("^entra en /$")
	public void entra_en() throws Throwable {
		startBD();
		driver.get("http://localhost:8080/");
	}

	@Entonces("^se ve la lista de las votaciones disponibles$")
	public void se_ve_la_lista_de_las_votaciones_disponibles() throws Throwable {
		SeleniumUtils.EsperaCargaPagina(driver, "text", "Solicitar voto electronico", 2); 
	}

	@Y("^decide la votacion y hace click en solicitar$")
	public void decide_la_votacion_y_hace_click_en_solicitar() throws Throwable {
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "apply", 2); 
		elementos.get(0).click();
	}

	@Entonces("^se le piden sus datos\\(correctos\\) para finalizar la votacion$")
	public void se_le_piden_sus_datos_correctos_para_finalizar_la_votacion() throws Throwable {
		SeleniumUtils.EsperaCargaPagina(driver, "text", "VoteApplication", 2); 
		rellenarFormulario("pepe@gmail.com", "12345");
	}

	@Entonces("^se le piden sus datos\\(incorrectos\\) para finalizar la votacion$")
	public void se_le_piden_sus_datos_incorrectos_para_finalizar_la_votacion() throws Throwable {
		SeleniumUtils.EsperaCargaPagina(driver, "text", "VoteApplication", 2); 
		rellenarFormulario("pepe@pepe.com", "12345");
	}

	@Y("^al ser correctos se le indica con un mensaje$")
	public void al_ser_correctos_se_le_indica_con_un_mensaje() throws Throwable {
		SeleniumUtils.EsperaCargaPagina(driver, "text", "Voto telematico admitido", 2); 
		CucumberTest.finishTest(driver);
	}

	@Entonces("^al ser incorrectos se le indica con un mensaje$")
	public void al_ser_incorrectos_se_le_indica_con_un_mensaje() throws Throwable {
		SeleniumUtils.EsperaCargaPagina(driver, "text", "Correo electronico y/o contraseña incorrectos", 2); 
		CucumberTest.finishTest(driver);
	}

	private void rellenarFormulario(String email, String password) {
		WebElement elemento = driver.findElement(By.id("input_form-cuerpo:email"));
		elemento.sendKeys(email);
		elemento = driver.findElement(By.id("input_form-cuerpo:password"));
		elemento.sendKeys(password);
		elemento = driver.findElement(By.id("form-cuerpo:solicitar"));
		elemento.click();

	}


}
