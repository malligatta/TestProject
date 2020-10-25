package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPages;

public class LoginPageTest extends TestBase {
	
	LoginPages loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginpage = new LoginPages();
		
	}
	
	@Test(priority=1)
	public void loginpageTileTest() {
		String title = loginpage.valudationTitlePage();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	

}
