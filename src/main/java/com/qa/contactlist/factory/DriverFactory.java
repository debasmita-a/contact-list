package com.qa.contactlist.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private WebDriver driver;
	private Properties prop;
	
	public WebDriver initDriver(Properties prop) {
		prop = initProp();
		System.out.println("Launching on browser.."+prop.getProperty("browser"));
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("Please provide correct browser name..");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
