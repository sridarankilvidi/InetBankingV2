package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;


public class TC_LoginDDT_002 extends BaseClass{

	
	@DataProvider(name="LoginData")
	String[][] getdata() throws IOException{
		
		String xlpath = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		String[][] data = com.inetbanking.utilities.XLUtils.GetData(xlpath,"Sheet1");
		return data;
	}
	
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		
		
		lp.setUserName(user);

		log.info("user name provided");

		lp.setPassword(pwd);

		log.info("password provided");

		lp.clickLogin();

		Thread.sleep(3000);

		if(isAlertPresent()==true)

		{
			//CaptureScreen(driver, "LoginDDT"); not working properly - investigate
			log.warn("Login failed");
			
			driver.switchTo().alert().accept();//close alert
			
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		

		else

		{

			log.info("Login passed");

			lp.clickLogout();

			Thread.sleep(3000);

			driver.switchTo().alert().accept();//close logout alert

			driver.switchTo().defaultContent();
			Assert.assertTrue(true);

		}
		
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not

	{

		try

		{

			driver.switchTo().alert();
	
			return true;

		}

		catch(NoAlertPresentException e)

		{

			return false;

		}

		

	}
	
	@AfterClass
	public void tearDownTest() {
		log.info("===exiting the application===");	
		tearDown();
	}
}
