package com.framework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(id="login_userName")
	@CacheLookup
	WebElement textName;
	
	@FindBy(id="login_password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath ="//*[@id=\"login\"]/div[4]/div/div/div/div/button/span")
	@CacheLookup
	WebElement btnLogin;
	
	public void setUsername(String uname) {
textName.sendKeys(uname);
		
	}
	public void setpassword(String pswd) {
		txtpassword.sendKeys(pswd);
				
			}
	public void clickSubmit() {
		btnLogin.click();
	}

}
