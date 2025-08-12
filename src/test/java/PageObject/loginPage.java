package PageObject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.configReader;

public class loginPage {
	
	WebDriver myDriver;
	private By usernameField;
	private By passwordField ;
	private By loginButtonField;
	private By InvalidCredentialsMessage;
	private By LogoDisplay;

	//Constructor
	public loginPage(WebDriver myDriver) {
		this.myDriver= myDriver;
	}
	
	//Locator
	//username method
		public void enterUserName(String username) throws IOException {
		Properties prop =configReader.getXpathProperties();         //Using prop obje
		String usernameXpath =prop.getProperty("username");        // one varible store prop value.
		usernameField=By.xpath(usernameXpath);                    //use that value creating xpath value. variable =by.xpath(value)
		myDriver.findElement(usernameField).sendKeys(username);  // mydriver.findelement(xpath value).sendkeys(by user in test001)
	}
	//password method
		public void enterPassword(String password) throws IOException {
			Properties prop =configReader.getXpathProperties(); 
			String passwordXpath =prop.getProperty("password");
			passwordField=By.xpath(passwordXpath);
			myDriver.findElement(passwordField).sendKeys(password);
		}
	//LoginButton method
		public void LoginButton() throws IOException {
			Properties prop =configReader.getXpathProperties(); 
			String loginbuttonXpath =prop.getProperty("loginButton");
			loginButtonField=By.xpath(loginbuttonXpath);
			myDriver.findElement(loginButtonField).click();
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