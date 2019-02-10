package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ReadConfig readconfig = new ReadConfig();
	
	public static WebDriver driver ;
	public String url = readconfig.getApplicationURL();
	public String uname = readconfig.getUserName();
	public String pwd = readconfig.getPassword();
	public String br = readconfig.getBrowser();
	public static Logger log;
	
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br) {
		log = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (br.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public void CaptureScreen(WebDriver driver, String tname) throws IOException  {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()

	{

		String generatedstring=RandomStringUtils.randomAlphabetic(8);

		return(generatedstring);

	}

	

	public static String randomeNum() {

		String generatedString2 = RandomStringUtils.randomNumeric(4);

		return (generatedString2);

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
