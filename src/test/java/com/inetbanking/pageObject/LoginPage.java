package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	
	@FindBy(name="uid")
	@CacheLookup
	static WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	static WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	static WebElement btnLogin;
	
	@FindBy(xpath= "//a[text()='Log out']")
	@CacheLookup
	static WebElement linkLogout;
	
	
	public LoginPage(WebDriver rdriver) {
		PageFactory.initElements(rdriver, this);
		ldriver = rdriver;
		
	}
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
		
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		linkLogout.click();
	}
	

}
