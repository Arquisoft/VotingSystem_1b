package es.uniovi.asw.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import es.uniovi.asw.util.SeleniumUtils;

public class CargaVotosInput {

	private WebDriver driver = SeleniumUtils.getDriver("VoteApplication");
	
	@Cuando("^Entra en la web$")
	public void entra_en_la_web() throws Throwable {
		driver.get("http://localhost:8080/");
	}

	@Entonces("^Va a la zona de votaciones para gestionar$")
	public void va_a_la_zona_de_votaciones_para_gestionar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		SeleniumUtils.esperaCargaPagina(driver, "text", "Ir a realizar la solicitud", 2);
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "id", "vote", 2);
		elementos.get(0).click();
	}

	@Entonces("^decide gestionar una votacion que quiere$")
	public void decide_gestionar_una_votacion_que_quiere() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //TODO
	}

	@Entonces("^rellena los votos de los partidos$")
	public void rellena_los_votos_de_los_partidos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		   // Write code here that turns the phrase above into concrete actions
	    //TODO
	}

	@Entonces("^introduciendo todos los votos y la cuenta \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void introduciendo_todos_los_votos_y_la_cuenta_y_password(String arg1, String arg2) throws Throwable {
		   // Write code here that turns the phrase above into concrete actions
	    //TODO
	}

	@Entonces("^introduciendo todos los votos y la cuenta que NO sea \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void introduciendo_todos_los_votos_y_la_cuenta_que_NO_sea_y_password(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		   // Write code here that turns the phrase above into concrete actions
	    //TODO
	}


	
}
