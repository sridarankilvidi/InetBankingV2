package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	// Constructor
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getApplicationURL() {
		
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getUserName() {
		
		String username = prop.getProperty("uname");
		return username;
	}
	
	public String getPassword() {
		
		String password = prop.getProperty("pwd");
		return password;
	}

	public String getBrowser() {
		
		String browser = prop.getProperty("br");
		return browser;
	}
}
