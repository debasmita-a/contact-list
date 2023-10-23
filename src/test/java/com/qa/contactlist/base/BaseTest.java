package com.qa.contactlist.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.contactlist.factory.DriverFactory;
import com.qa.contactlist.pages.AddContact;
import com.qa.contactlist.pages.ContactListPage;
import com.qa.contactlist.pages.LoginPage;

public class BaseTest {

	protected DriverFactory df;
	protected Properties prop;
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected ContactListPage contactlistPage;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		//driver.quit();
	}
}
