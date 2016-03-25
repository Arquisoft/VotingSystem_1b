package es.uniovi.asw;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.util.SeleniumUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@ContextConfiguration(classes = Main.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
public class TestMain {

	WebDriver driver;
	List<WebElement> elementos = null;

	public TestMain(){
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
	public void end() {
		driver.quit();
	}



	@Test
	public void EjemploTest() throws InterruptedException {
		
		//Vamos a la vista de autocomplete
		driver.get("http://localhost:8080/index.xhtml");

		//Esperamos que aparezca el elemento themeCustom_input 
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "text", "Hola", 2); 

	}

}
