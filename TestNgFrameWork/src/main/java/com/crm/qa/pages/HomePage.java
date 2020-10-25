package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id='main-nav']/a[3]")
	WebElement contactlink;

	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	WebElement newContactlink;

	@FindBy(xpath = "//*[@id='main-nav']/a[5]")
	WebElement deallink;

	@FindBy(xpath = "//*[@id='main-nav']/a[6]")
	WebElement tasklink;

	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public 	ContactsPage clickOnContactlink() {
		contactlink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealslink() {
		deallink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonSignUplink() {
		
		tasklink.click();
		return new TasksPage();
	}

}
