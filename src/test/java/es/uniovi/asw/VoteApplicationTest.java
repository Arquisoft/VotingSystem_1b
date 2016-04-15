package es.uniovi.asw;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.saucelabs.saucerest.SauceREST;

import es.uniovi.asw.dbupdate.model.ConfigurationElection;
import es.uniovi.asw.dbupdate.model.ElectoralCollege;
import es.uniovi.asw.dbupdate.model.User;
import es.uniovi.asw.dbupdate.model.VotableOption;
import es.uniovi.asw.dbupdate.repositories.ConfigurationDAO;
import es.uniovi.asw.dbupdate.repositories.UserDAO;
import es.uniovi.asw.util.SeleniumUtils;

@WebAppConfiguration
@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class VoteApplicationTest {


	WebDriver driver;
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

	@Before
	public void run() throws Exception{

		if(System.getenv().get("TRAVIS_JOB_NUMBER") != null){

			URL url = new URL("http://" + System.getenv().get("SAUCE_USERNAME") + ":" 
					+ System.getenv().get("SAUCE_ACCESS_KEY") + "@ondemand.saucelabs.com/wd/hub");
			
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("tunnel-identifier", System.getenv().get("TRAVIS_JOB_NUMBER"));
	        capabilities.setCapability("name", "Vote Application");

			driver = new RemoteWebDriver(url, capabilities);

		}
		else{
			driver = new FirefoxDriver();
		}

	}

	@After
	public void close() throws Exception{
		
		if (System.getenv().get("TRAVIS_JOB_NUMBER") != null) {
			SauceREST sauceRest = new SauceREST(System.getenv().get("SAUCE_USERNAME"), System.getenv().get("SAUCE_ACCESS_KEY"));
			sauceRest.jobPassed((((RemoteWebDriver) driver).getSessionId()).toString());
		}
		
		driver.close();
		driver.quit();
	}

	@Test
	public void DatosIncorrectos() throws InterruptedException {

		driver.get("http://localhost:8080/");
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "apply", 2); 
		elementos.get(0).click();
		
		SeleniumUtils.EsperaCargaPagina(driver, "text", "VoteApplication", 2); 
		rellenarFormulario("pepe@pepe.com", "12345");
		SeleniumUtils.EsperaCargaPagina(driver, "text", "Correo electronico y/o contraseña incorrectos", 2); 

	}

	@Test
	public void DatosCorrectos() throws InterruptedException {

		driver.get("http://localhost:8080/");
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "apply", 2); 
		elementos.get(0).click();
		
		SeleniumUtils.EsperaCargaPagina(driver, "text", "VoteApplication", 2); 
		rellenarFormulario("pepe@gmail.com", "12345");
		SeleniumUtils.EsperaCargaPagina(driver, "text", "Voto telematico admitido", 2); 

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
