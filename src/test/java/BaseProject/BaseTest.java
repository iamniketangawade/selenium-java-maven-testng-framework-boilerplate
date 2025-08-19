package BaseProject;

import java.io.IOException;

import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;  
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import utilities.configReader;

public class BaseTest{
	
	public WebDriver myDriver;
	public Properties prop;
	public Logger logger =LogManager.getLogger(BaseTest.class);



	
	
	@BeforeClass
	public void setUp() throws IOException {
		logger.info("===== STARTED BROWSER ===== ");

		prop=configReader.getProperties();
		String browser =prop.getProperty("browser");
		String url =prop.getProperty("url");

		if(browser.equals("chrome")) {
			myDriver =new ChromeDriver(); 
		}
		else if(browser.equals("firefox")) {
			myDriver =new FirefoxDriver();
		}
		else {
			System.out.println("User pass not valid parameter in browser.properties variable");
		}
	
		myDriver.manage().window().maximize();
		myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		myDriver.get(url);
	
	}
	

	
	
	
	@AfterClass
	public void tearDown() {
		
		if(myDriver!=null) {
			logger.info("===== ENDED BROWSER ===== ");
			myDriver.quit();
		}
	}
	
	

}
