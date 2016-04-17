package es.uniovi.asw.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import es.uniovi.asw.util.SeleniumUtils;

public class VoterVote {
	
	private WebDriver driver = SeleniumUtils.getDriver("VoterVote");
	
	@Cuando("^entra en / para votar$")
	public void entra_en_para_votar() throws Throwable {
		driver.get("http://localhost:8080/");
	}

	@Entonces("^se ve la lista de las votaciones disponibles para votar$")
	public void se_ve_la_lista_de_las_votaciones_disponibles_para_votar() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "Ir a votar", 2); 
	}

	@Entonces("^decide la votacion y hace click$")
	public void decide_la_votacion_y_hace_click() throws Throwable {
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "id", "vote", 2); 
		elementos.get(0).click();
	}

	@Entonces("^se le muestrarn las opciones disponibles$")
	public void se_le_muestrarn_las_opciones_disponibles() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "PP", 2); 
		SeleniumUtils.esperaCargaPagina(driver, "text", "PSOE", 2); 
		SeleniumUtils.esperaCargaPagina(driver, "text", "Cs", 2); 
		SeleniumUtils.esperaCargaPagina(driver, "text", "Podemos", 2); 
		SeleniumUtils.finishTest(driver);
	}

}
