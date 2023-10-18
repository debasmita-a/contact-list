package com.qa.contactlist.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.contactlist.base.BaseTest;
import com.qa.contactlist.pages.AddContact;
import com.qa.contactlist.pages.ContactListPage;

public class ContactListPageTest extends BaseTest{

	@BeforeClass
	public ContactListPage setupContactListPage() {
		contactlistPage = loginPage.doLogin(prop.getProperty("user_email"), prop.getProperty("user_pass"));
		return contactlistPage;
	}
	
	@DataProvider
	public Object[][] addContactTestData(){
		return new Object[][] {
			{"newtest1","Test1", "", "", "", "", "", "", "", "", ""},
			{"newtest2","Test2", "", "", "", "", "", "", "", "", ""},
			{"newtest3","Test3", "", "", "", "", "", "", "", "", ""},
			{"newtest4","Test4", "", "", "", "", "", "", "", "", ""},
			{"newtest5","Test5", "", "", "", "", "", "", "", "", ""},
			
		};
	}
	
	@Test(dataProvider="addContactTestData")
	public void addAContactTest(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8,
			String s9, String s10, String s11) {
		AddContact addContact = new AddContact(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
		String actualName = contactlistPage.addAContact(addContact);
		Assert.assertTrue(actualName.contains(addContact.getFirstname()));
	}
	
	@DataProvider
	public Object[][] getContactTestData(){
		return new Object[][] {
			{"Ross"},
			{"Gunther"},
			{"Jane"}
		};
	}
	@Test(dataProvider="getContactTestData")
	public void getContactTest(String fname) {
		Map<String, String> actualMap = contactlistPage.getContact(fname);
		Assert.assertEquals(actualMap.get("FirstName"), fname);
	}
	
	@Test(dataProvider="addContactTestData")
	public void deleteContactTest(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8,
			String s9, String s10, String s11) {
		AddContact addContact = new AddContact(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
		contactlistPage.addAContact(addContact);
		boolean flag = contactlistPage.deleteContact(s1);
		Assert.assertFalse(flag);
	}

}
