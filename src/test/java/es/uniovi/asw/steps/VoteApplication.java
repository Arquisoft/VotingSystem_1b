package es.uniovi.asw.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import es.uniovi.asw.Main;
import es.uniovi.asw.util.SeleniumUtils;

@ContextConfiguration(classes=Main.class, loader=SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
public class VoteApplication {

	private WebDriver driver = SeleniumUtils.getDriver("VoteApplication");
	
	@Cuando("^entra en /$")
	public void entra_en() throws Throwable {
		driver.get("http://localhost:8080/");
	}

	@Entonces("^se ve la lista de las votaciones disponibles$")
	public void se_ve_la_lista_de_las_votaciones_disponibles() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "Ir a realizar la solicitud", 2); 
	}

	@Y("^decide la votacion y hace click en solicitar$")
	public void decide_la_votacion_y_hace_click_en_solicitar() throws Throwable {
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "id", "apply", 2); 
		elementos.get(0).click();
	}

	@Entonces("^se le piden sus datos\\(correctos\\) para finalizar la votacion$")
	public void se_le_piden_sus_datos_correctos_para_finalizar_la_votacion() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "VoteApplication", 2); 
		rellenarFormulario("pepe@gmail.com", "12345");
	}

	@Entonces("^se le piden sus datos\\(incorrectos\\) para finalizar la votacion$")
	public void se_le_piden_sus_datos_incorrectos_para_finalizar_la_votacion() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "VoteApplication", 2); 
		rellenarFormulario("pepe@pepe.com", "12345");
	}

	@Y("^al ser correctos se le indica con un mensaje$")
	public void al_ser_correctos_se_le_indica_con_un_mensaje() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "Voto telematico admitido", 2); 
		SeleniumUtils.finishTest(driver);
	}

	@Entonces("^al ser incorrectos se le indica con un mensaje$")
	public void al_ser_incorrectos_se_le_indica_con_un_mensaje() throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", "Correo electronico y/o contraseña incorrectos", 2); 
		SeleniumUtils.finishTest(driver);
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
