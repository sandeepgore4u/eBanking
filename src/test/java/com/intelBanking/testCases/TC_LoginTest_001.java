package com.intelBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.intelBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void loginTest() throws IOException {
		
		driver.get(baseurl);
		logger.info("URL is Open");
		
		LoginPage login=new LoginPage(driver);
		
		
		login.setTxtUserName(userName);
		logger.info("Entered UserName");
		
		login.setTxtPassword(password);
		logger.info("Entered Password");
		
		login.clickSubmit();
		logger.info("Login button Clicked");
		String title=driver.getTitle();
		//System.out.println(title);
		
		if(title.equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}else
		{
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
	}

}
