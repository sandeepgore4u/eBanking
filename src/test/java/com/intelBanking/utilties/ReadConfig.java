package com.intelBanking.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public Properties prop;
	
	public ReadConfig() {
		File file=new File("./Configuration/config.properties");

		try {
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public String getBaseurl() {
		return prop.getProperty("baseurl");

	}
	public String getUserName() {
		
		return prop.getProperty("username");

	}
	public String getPassword() {
		return prop.getProperty("password");

	} 
	public String getChromeDriver() {
		return prop.getProperty("chromedriver");

	} 
	public String getChromeDriverPath() {
		return prop.getProperty("chromedriverpath");

	} 
	public String getFirefoxDriver() {
		return prop.getProperty("firefoxdriver");

	} 
	public String getFirefoxDriverPath() {
		return prop.getProperty("firefoxdriverpath");

	} 
	public String getIEDriver() {
		return prop.getProperty("iedriver");

	} 
	public String getIEDriverPath() {
		return prop.getProperty("iedriverpath");

	} 
 }

