package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;
import BaseProject.BaseTest;
import PageObject.loginPage;



public class LoginPageTestcases extends BaseTest{
	
	public Logger logger =LogManager.getLogger(LoginPageTestcases.class);
	
	@Test
	public void tc001() throws IOException{  //LoginPage ::Send correct username and password
		loginPage logpg =new loginPage(myDriver);
		System.out.println("TC001 :: LoginPage ::Send correct username and password");
		logger.info("=========STARTED :: TC001==============");
		logpg.Login("admin", "admin123");
		logger.info("=========ENDED :: TC001==============");

	}//method end tc001

	
	//@Test
	public void tc002() throws IOException{  //LoginPage ::Send incorrect username and password
		System.out.println("TC002 :: LoginPage ::Send incorrect username and password");
		loginPage logpg =new loginPage(myDriver);
		try {
		logpg.Login("username", "admin1243");
		System.out.println(logpg.InvalidMessage() + ":: Invalid Message Display");
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());

		}	
	} //method end tc002
	
	//@Test
	public  void tc003() { //LoginPage ::Send correct username and incorrect password
		System.out.println("TC003 :: LoginPage ::Send correct username and incorrect password");
		loginPage logpg =new loginPage(myDriver);
		try {
		logpg.Login("admin", "xyz12345");
		System.out.println(logpg.InvalidMessage() + ":: Invalid Message Display");
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());

		}	
	}//method end tc003
	
	//@Test
	public  void tc004() { //LoginPage ::Send incorrect username and correct password
		System.out.println("TC004 :: LoginPage ::Send incorrect username and correct password");
		loginPage logpg =new loginPage(myDriver);
		try {
		logpg.Login("xadmin", "admin123");
		System.out.println(logpg.InvalidMessage() + ":: Invalid Message Display");
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());

		}	
	}//method end tc004
	
	//@Test
	public void tc005() throws IOException, InterruptedException { //LoginPage :: logo is display
		loginPage logpg =new loginPage(myDriver);
		
		logpg.LogoDisplay();
		System.out.println("Logo is display :: "+logpg.LogoDisplay());
	}
	

}
