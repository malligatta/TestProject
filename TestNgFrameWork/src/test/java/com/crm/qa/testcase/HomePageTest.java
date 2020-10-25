package com.crm.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPages;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	
	LoginPages loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginpage = new LoginPages();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM"," HomePage tile not mached");
	}
	
	
   	@Test(priority=2)
   	public void clickOnContactlinktest() {
   		contactspage = homepage.clickOnContactlink();
   	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
