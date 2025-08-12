package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseProject.BaseTest;
import PageObject.loginPage;


public class Testcases extends BaseTest{

	@Test
	public void tc001() throws IOException{  //LoginPage ::Send correct username and password
		System.out.println("TC001 :: LoginPage ::Send correct username and password");
		loginPage logpg =new loginPage(myDriver);
		logpg.Login("admin", "admin123");
		
		Assert.assertTrue(myDriver.getCurrentUrl().contains("dashboard"),"login Passed with correct creaditals");
	}//method end tc001

	
	@Test
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
	
	@Test
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
	
	@Test
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
	
	
	@Test
	public  void tc005() throws IOException { //LoginPage ::Logo is display or not.
		System.out.println("TC004 :: LoginPage ::Logo is display or not.");
		loginPage logpg =new loginPage(myDriver);
		if(logpg.LogoDisplay()){
			System.out.println("Logo is display on Login page");
		}
		else {
			System.out.println("Logo is not display on Login page");
		}
		}//method end tc005	
	
	
	
	
	
	
	
}
