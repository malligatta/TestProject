package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	WebElement newContactlink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	

}
