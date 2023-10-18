package com.qa.contactlist.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// //table[@id="myTable"]/tr/td[contains(.,"Pheobe")]
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		driver.findElement(By.id("email")).sendKeys("debasmita1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("debasmita@1");
		driver.findElement(By.id("submit")).click();
	
		/*
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-contact")))
		 * .click();
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName"))).
		 * sendKeys("Jane");
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))).
		 * sendKeys("Austen");
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit"))).
		 * click();
		 */
		
		//tr/td[contains(text(),'cooco')]
		/*
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//tr/td[contains(text(),'test')]"))).click();
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edit-contact"))
		 * ).click();
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("city"))).
		 * sendKeys("London");
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("country"))).
		 * sendKeys("UK");
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit"))).
		 * click();
		 */
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr/td[text()='Gunther Test']"))).click();
		
		/*
		 * String fname =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")))
		 * .getText(); String lname =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).
		 * getText()
		 */;
		
		/*
		 * //String dob =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("birthdate")))
		 * .getText(); String email =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).
		 * getText(); String ph =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).
		 * getText(); String city =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).
		 * getText(); String state =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "stateProvince"))).getText(); String postalCode =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postalCode"))
		 * ).getText(); String country =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country"))).
		 * getText(); String addr1 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("street1"))).
		 * getText(); String addr2 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("street2"))).
		 * getText();
		 */
		//System.out.println(fname);
		//System.out.println(dob);
		
		//ap<String, String> contactMap = new HashMap<String, String>();
		
		//contactMap.put("FirstName", fname);
		//contactMap.put("LastName", lname);
		/*
		 * //contactMap.put("DOB", dob); contactMap.put("Email", email);
		 * contactMap.put("Phone", ph); contactMap.put("City", city);
		 * contactMap.put("State", state); contactMap.put("PostalCode", postalCode);
		 * contactMap.put("Country", country); contactMap.put("Street1", addr1);
		 * contactMap.put("Street2", addr2);
		 */
		
		//System.out.println(contactMap);
	//System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-contact11"))).isDisplayed());
		
    try{
    	driver.findElement(By.id("add-contact11")).isDisplayed();
        System.out.println("true");
    }catch(NoSuchElementException e ){
    	System.out.println("false");
    }
	}

}
