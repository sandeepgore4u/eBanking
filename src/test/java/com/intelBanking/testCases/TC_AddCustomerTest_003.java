package com.intelBanking.testCases;

import org.testng.annotations.Test;

import com.intelBanking.pageObjects.AddNewCustomerPage;
import com.intelBanking.pageObjects.LoginPage;

import java.io.IOException;


import org.testng.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lg=new LoginPage(driver);
		
		lg.setTxtUserName(userName);
		logger.info("User Name provided");
		
		lg.setTxtPassword(password);
		logger.info("Password provided");
		
		lg.clickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Providing customer details..");
		AddNewCustomerPage addcust=new AddNewCustomerPage(driver);
		
		addcust.clickNewCustomer();
		addcust.customerName("Sandeep Gore");
		addcust.gender("male");
		addcust.dateOfBirth("12","04","1985");
		addcust.address("wagholi");
		addcust.city("pune");
		addcust.state("maharashtra");
		int pinno=Integer.parseInt(randomNumber());
		addcust.pin(pinno);
		addcust.mobileNo("9881456789");
		String emailId=randomString()+"@gmail.com";
		addcust.emailId(emailId);
		addcust.password("abcd");
		addcust.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registerd Successfully!!!");
		
		if (res==true) {
			Assert.assertTrue(true);
			logger.info("TastCase passed");
			
		}else {
			captureScreenshot(driver, "addNewCustomer");
			logger.info("TastCase Failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
}
