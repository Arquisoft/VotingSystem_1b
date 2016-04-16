package es.uniovi.asw;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.saucelabs.saucerest.SauceREST;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class CucumberTest{
	
	public static WebDriver getDriver(String testName){
		WebDriver driver;
		
		if(System.getenv().get("TRAVIS_JOB_NUMBER") != null){

			URL url = null;
			try {
				url = new URL("http://" + System.getenv().get("SAUCE_USERNAME") + ":" 
						+ System.getenv().get("SAUCE_ACCESS_KEY") + "@ondemand.saucelabs.com/wd/hub");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("tunnel-identifier", System.getenv().get("TRAVIS_JOB_NUMBER"));
	        capabilities.setCapability("name", testName);

			driver = new RemoteWebDriver(url, capabilities);

		}
		else{
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
	
	public static void finishTest(WebDriver driver){
		if (System.getenv().get("TRAVIS_JOB_NUMBER") != null) {
			SauceREST sauceRest = new SauceREST(System.getenv().get("SAUCE_USERNAME"), System.getenv().get("SAUCE_ACCESS_KEY"));
			sauceRest.jobPassed((((RemoteWebDriver) driver).getSessionId()).toString());
		}
		
		driver.close();
		driver.quit();
	}
	
}