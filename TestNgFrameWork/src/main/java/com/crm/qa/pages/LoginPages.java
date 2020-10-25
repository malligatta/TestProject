package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPages extends TestBase{
	
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	WebElement loginbtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpbtn; 
	
	public LoginPages() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String valudationTitlePage() {
		return driver.getTitle();
	}
	
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
	
}
