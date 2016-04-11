package es.uniovi.asw;

import java.net.URL;

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

import es.uniovi.asw.dbupdate.model.User;
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
	
	private static boolean setUpIsDone = false;
	
	@Before
	public void startBD(){
		if(!setUpIsDone){
			User user = new User("Pepe", "pepe@gmail.com", "74321123N", "321");
			user.setContrasena("12345");
			
			ud.save(user);
			setUpIsDone = true;
		}
	}
	
	@Before
	public void run() throws Exception{
		
		if(System.getenv().get("TRAVIS_JOB_NUMBER") != null){
			
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setCapability("tunnel-identifier", System.getenv().get("TRAVIS_JOB_NUMBER"));
			
			URL url = new URL("http://" + System.getenv().get("SAUCE_USERNAME") + ":" 
					+ System.getenv().get("SAUCE_ACCESS_KEY") + "@ondemand.saucelabs.com/wd/hub");
			
			driver = new RemoteWebDriver(url, capability);

		}
		else{
			driver = new FirefoxDriver();
		}

	}
	
	@After
	public void close() throws Exception{
		driver.close();
	}
	
	@Test
	public void DatosIncorrectos() throws InterruptedException {
		
		driver.get("http://localhost:8080/application/index.xhtml");
		SeleniumUtils.EsperaCargaPagina(driver, "text", "VoteApplication", 2); 
		
		rellenarFormulario("pepe@pepe.com", "12345");
		
		SeleniumUtils.EsperaCargaPagina(driver, "text", "Correo electronico y/o contraseña incorrectos", 2); 

	}

	@Test
	public void DatosCorrectos() throws InterruptedException {
		
		driver.get("http://localhost:8080/application/index.xhtml");
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
