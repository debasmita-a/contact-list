package com.qa.contactlist.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.contactlist.factory.DriverFactory;
import com.qa.contactlist.pages.AddContact;
import com.qa.contactlist.pages.ContactListPage;

public class BaseTest {

	DriverFactory df;
	Properties prop;
	WebDriver driver;
	protected ContactListPage contactlistPage;
	protected AddContact addContact;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		addContact = new AddContact();
		contactlistPage = new ContactListPage(driver);

	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
