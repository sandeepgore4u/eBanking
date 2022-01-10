package com.intelBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intelBanking.pageObjects.LoginPage;
import com.intelBanking.utilties.XLUtils;

public class TC_LoginTest_002 extends BaseClass {
 @Test(dataProvider="LoginData")
public void loginDDT(String user,String pwd) {
	 
	 LoginPage lp=new LoginPage(driver);
	 lp.setTxtUserName(user);
	 logger.info("User name provided");
	 lp.setTxtPassword(pwd);
	 logger.info("Password is  provided");
	 lp.clickSubmit();
	 
	 if (isAlertPresent()==true) {
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(true);
		 logger.warn("Login Failed");
	 }
	 else {
		 
		 Assert.assertTrue(false);
		 lp.clickLogout();
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 logger.info("Login Passed");
		 
	 }
 }
 
 public boolean isAlertPresent() {
	 
	 try
	 {
		driver.switchTo().alert();
	    return true;
	 }catch(NoAlertPresentException e)
	 {
		 return false;
	 }
	 
 }
 
 @DataProvider(name="LoginData")
  
  String[][] getData() throws IOException{
	 
	 String path="E:\\CoreJava\\intelBanking\\src\\test\\java\\com\\intelBanking\\testData\\LoginData.xlsx";
     int rowcount=XLUtils.getRowCount(path,"Sheet1");
     int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
     String logindata[][]=new String[rowcount][colcount];
     for(int i=1;i<=rowcount;i++) {
    	 for(int j=0;j<colcount;j++) {
    		 logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
    	 }
    		 
     }
    return logindata;
 }
}
