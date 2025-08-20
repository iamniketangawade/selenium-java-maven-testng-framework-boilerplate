package PageObject;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import BaseProject.BaseTest;
import tests.LoginPageTestcases;
import utilities.configReader;

public class loginPage extends BaseTest {
	
	WebDriver myDriver;
	private By usernameField;
	private By passwordField ;
	private By loginButtonField;
	private By InvalidCredentialsMessage;
	private By LogoDisplay;
	
	public Logger logger =LogManager.getLogger(LoginPageTestcases.class);


	//Constructor
	public loginPage(WebDriver myDriver) {
		this.myDriver= myDriver;
	}
	
	//Locator
	//username method
		public void enterUserName(String username) throws IOException {
		Properties prop =configReader.getXpathProperties();         //Using prop obje
		logger.info("Loaded Xpath properties successfully.");
		String usernameXpath =prop.getProperty("username");        // one varible store prop value.
	    logger.info("Retrieved password field Xpath: " + usernameXpath);
		usernameField=By.xpath(usernameXpath);                    //use that value creating xpath value. variable =by.xpath(value)
	    logger.info("Located username field using Xpath.");
		myDriver.findElement(usernameField).sendKeys(username);  // mydriver.findelement(xpath value).sendkeys(by user in test001)
	    logger.info("username entered successfully.");
	}
	//password method
		public void enterPassword(String password) throws IOException {
			Properties prop =configReader.getXpathProperties(); 
			logger.info("Loaded Xpath properties successfully.");
			String passwordXpath =prop.getProperty("password");
			logger.info("Retrieved password field Xpath: " + passwordXpath);
			passwordField=By.xpath(passwordXpath);
			logger.info("Located password field using Xpath.");
			myDriver.findElement(passwordField).sendKeys(password);
			logger.info("Password entered successfully.");
		}
	//LoginButton method
		public void LoginButton() throws IOException {
			Properties prop =configReader.getXpathProperties(); 
			logger.info("Loaded loginbuttonXpath properties successfully.");
			String loginbuttonXpath =prop.getProperty("loginButton");
			logger.info("Retrieved password field Xpath: " + loginbuttonXpath);
			loginButtonField=By.xpath(loginbuttonXpath);
			myDriver.findElement(loginButtonField).click();
			logger.info("successfully Click on Submit button.");
		}
	//InvalidMessageOccurOnLoginPage
		public boolean InvalidMessage() throws IOException {
			Properties prop =configReader.getXpathProperties(); 
			String InvalidCredentialsXpath =prop.getProperty("InvalidCredentials");
			InvalidCredentialsMessage=By.xpath(InvalidCredentialsXpath);
			boolean message =myDriver.findElement(InvalidCredentialsMessage).isDisplayed();
			return message;
		}
		public boolean LogoDisplay() throws IOException{
			Properties prop =configReader.getXpathProperties();
			String logoXpath=prop.getProperty("logo");
			LogoDisplay=By.xpath(logoXpath);

			boolean logo =myDriver.findElement(LogoDisplay).isDisplayed();
			return logo;
		}
		
		public void Login(String username,String password) throws IOException {
			try {
				enterUserName(username);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				enterPassword(password);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LoginButton();
		}
		
		

}