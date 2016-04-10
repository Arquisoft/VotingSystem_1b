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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.util.SeleniumUtils;

@WebAppConfiguration
@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class PruebaSeleniumTest {

	WebDriver driver;
	List<WebElement> elementos = null;

	public PruebaSeleniumTest(){
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
	public void EjemploTest() throws InterruptedException {
		
		driver.get("http://localhost:8080/index.xhtml");
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "text", "Hola", 2); 

	}
	
	@Test
	public void EjemploCambioIndex() throws InterruptedException {
		
		driver.get("http://localhost:8080/");
		SeleniumUtils.EsperaCargaPagina(driver, "text", "VoterVote", 2); 
		driver.get("http://localhost:8080/");
		SeleniumUtils.EsperaCargaPagina(driver, "text", "VoteApplication", 2); 
		

	}

}
