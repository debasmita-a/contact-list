package com.qa.contactlist.tests;

import org.testng.annotations.Test;

import com.qa.contactlist.base.BaseTest;

public class ContactListPageTest extends BaseTest{

	@Test
	public void addAContactTest() {
		contactlistPage.addAContact(addContact);
	}
}
