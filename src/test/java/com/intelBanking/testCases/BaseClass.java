package com.intelBanking.testCases;


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

import com.intelBanking.utilties.ReadConfig;

public class BaseClass {

	ReadConfig config=new ReadConfig(); 

	String baseurl=config.getBaseurl();
	String userName=config.getUserName();
	String password = config.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");


		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",config.getChromeDriverPath());
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",config.getFirefoxDriverPath());
			driver=new FirefoxDriver();
		}if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",config.getIEDriverPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
   }
	
	public void captureScreenshot(WebDriver driver,String tname )throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
    }

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	public String randomString() {

		String genratedString=RandomStringUtils.randomAlphanumeric(8);
		return genratedString;

	}
	public  String randomNumber() {

		String genratedNumber=RandomStringUtils.randomNumeric(4);
		return genratedNumber;

	}
}
