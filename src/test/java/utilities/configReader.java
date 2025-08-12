package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	//Create one Class variable Properties 
	static Properties prop;
	
	//Create a method getProperties
	public static Properties getProperties() throws IOException {
		prop=new Properties();
		FileInputStream filepath =new FileInputStream("C:\\Users\\Niketan.Gawade\\eclipse-workspace\\RoyalCBProject\\src\\test\\resources\\config.properties");
		prop.load(filepath);  //Loading file

		return prop;
	}
	
	//Create a method getXpathProperties
	public static Properties getXpathProperties() throws IOException {
		prop =new Properties();
		FileInputStream filepath=new FileInputStream("C:\\Users\\Niketan.Gawade\\eclipse-workspace\\RoyalCBProject\\src\\test\\resources\\LoginpageXpath.properties");
		prop.load(filepath);
		return prop;
		
	}


}
