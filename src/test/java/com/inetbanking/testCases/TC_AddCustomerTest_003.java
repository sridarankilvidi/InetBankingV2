package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test

	public void addNewCustomer() throws InterruptedException, IOException

	{

		LoginPage lp=new LoginPage(driver);

		lp.setUserName(uname);

		log.info("User name is provided");

		lp.setPassword(pwd);

		log.info("Passsword is provided");

		lp.clickLogin();

		Thread.sleep(3000);

		AddCustomerPage addcust=new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		log.info("providing customer details....");

		addcust.custName("Sridaran");

		addcust.custgender("male");

		addcust.custdob("08","19","1970");

		Thread.sleep(5000);

		addcust.custaddress("CANADA");

		addcust.custcity("MONTREAL");

		addcust.custstate("QUEBEC");

		addcust.custpinno("5000074");

		addcust.custtelephoneno("5141111234");

		

		String email=randomestring()+"@gmail.com";

		addcust.custemailid(email);

		addcust.custpassword("abcdef");

		addcust.custsubmit();

		Thread.sleep(3000);
		
		log.info("validation started....");

		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)

		{
			log.info("addNewCustomer() test case passed....");

			Assert.assertTrue(true);
			
		}

		else

		{

			log.info("addNewCustomer() test case failed....");

			CaptureScreen(driver,"addNewCustomer");

			Assert.assertTrue(false);

		}

			

	}

}
