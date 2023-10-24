package com.qa.contactlist.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionManager optionManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop) {
		optionManager = new OptionManager(prop);
		System.out.println("Launching on browser.."+prop.getProperty("browser"));
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			//driver = new ChromeDriver(optionManager.getChromeOptions(prop));
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions(prop)));
		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			//driver = new FirefoxDriver(optionManager.getFirefoxOptions(prop));
			tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions(prop)));
		}else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver(optionManager.getEdgeOptions(prop)));
		}else {
			System.out.println("Please provide correct browser name..");
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		return getDriver();
	}
	/**
	 * every thread will get their own driver.there will be no deadlock conditions.
	 * 
	 * get the thread local copy of the driver
	 * @return tlDriver
	 */
	public synchronized static WebDriver getDriver() { 
		return tlDriver.get();
	}
	
	/*
	 * this method is reading the properties from the .propeties file
	 * 
	 */
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
	
	public static String getScreenshot() {
		File srcfile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcfile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
}
