package com.intelBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 
	WebDriver diver;
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	
	WebElement btnLogin;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	public LoginPage(WebDriver rdiver) {
		this.diver = rdiver;
		PageFactory.initElements(rdiver, this); 
	}
	
	public void setTxtUserName(String userName) {
	      System.out.println(userName);
		txtUserName.sendKeys(userName);
	}

	public void setTxtPassword(String password) {
		System.out.println(password);
		txtPassword.sendKeys(password); 
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogout() {
      lnkLogout.click();
	}
	
 
 
}
