package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;


public class TC_LoginTest_001 extends BaseClass{
	LoginPage lp;
	
	@Test
	public void loginTest() throws IOException {
		
		lp = new LoginPage(driver);
		
		lp.setUserName(uname);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		log.info("===login btn clicked===");		
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			log.info("===login is successful===");	
			Assert.assertTrue(true);
			
		}else {
			CaptureScreen(driver, "loginTest");
			log.info("===login is not successful===");	
			Assert.assertTrue(false);
			
		}
	}
	
	
	@AfterClass
	public void tearDownTest() {
		log.info("===exiting the application===");	
		tearDown();
	}
}
