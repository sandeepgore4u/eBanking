package com.intelBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.common.util.concurrent.Service.State;

public class AddNewCustomerPage {
	WebDriver driver;

	public AddNewCustomerPage(WebDriver rdriver) {
		super();
		this.driver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div(3)/div/ul/li(2)/a")
	@CacheLookup
	WebElement lnkaddcustomer;
	
	@FindBy(how=How.NAME,using="name")
	@CacheLookup
	WebElement txtcustomer;
	
	@FindBy(how=How.NAME,using="rad1")
	@CacheLookup
	WebElement rdgender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	@CacheLookup	
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how=How.NAME,using="pin")
	@CacheLookup
	WebElement txtpin;
	
	@FindBy(how=How.NAME,using="telephoneno")
	@CacheLookup
	WebElement txtmobile;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how=How.NAME,using="sub")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(how=How.NAME,using="res")
	@CacheLookup
	WebElement btnreset;
	
	public void clickNewCustomer() {
		
		lnkaddcustomer.click();
	}
	
	public void customerName(String custname) {
		txtcustomer.sendKeys(custname);

	}
	
	public void dateOfBirth(String dd,String mm,String yy ) {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);

	}
	
	public void address(String address) {
		
		txtaddress.sendKeys(address);
	}
	public void city(String city) {
		txtcity.sendKeys(city);
	}
	public void gender(String gender) {
		rdgender.click();

	}
	
	public void state(String custstate) {
		txtstate.sendKeys(custstate);

	}
	
	public void pin(int  pin) {
		txtpin.sendKeys(String.valueOf(pin));
	}
	public void mobileNo(String mobileno) {
		txtmobile.sendKeys(mobileno);
	}
	public void emailId(String emailId) {
		txtemail.sendKeys(String.valueOf(emailId));
	}
	
	public void password(String password) {
		txtpassword.sendKeys(password);

	}
	public void clickSubmit() {
		btnsubmit.click();
	}
	public void clickReset() {
		btnreset.click();
	}
}
