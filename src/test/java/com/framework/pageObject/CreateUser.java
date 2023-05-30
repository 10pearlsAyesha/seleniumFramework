package com.framework.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;


public class CreateUser {

	WebDriver ldriver;
	public CreateUser(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	Faker fake=new Faker();
	@FindBy(xpath ="//*[@id=\"root\"]/section/section/main/div/div[1]/div[1]/button/span")
	@CacheLookup
	WebElement createnewuser;
	
	
	@FindBy(xpath ="//input[@name=\"fullName\"]")
	@CacheLookup
	WebElement UserFullName;
	@FindBy(xpath ="//input[@name=\"email\"]")
	@CacheLookup
	public
	WebElement Usermail;
	@FindBy(xpath ="//*[@id=\"rc_select_4\"]")
	@CacheLookup
	WebElement userRoleDrop;
	@FindBy(xpath ="//div[text()=\"Validation Engineer\"]")
	@CacheLookup
	WebElement SelectUserRole;
	@FindBy(xpath ="//*[@id=\"rc_select_5\"]")
	@CacheLookup
	WebElement clientDrop;
	@FindBy(xpath ="//div[text()=\"Merrill\"]")
	@CacheLookup
	WebElement selectclient;
	@FindBy(xpath ="//*[@id=\"adminForm\"]/div[11]/div/div/div/div/div/div[1]/button/span")
	@CacheLookup
	WebElement save;
	@FindBy(xpath ="//*[@id=\"adminForm\"]/div[11]/div/div/div/div/div/div[2]/button/span")
	@CacheLookup
	WebElement cancel;
	@FindBy(xpath ="//table/tbody/tr[2]/td[1]")
	@CacheLookup
	WebElement existuser;
	public String fakename=fake.name().fullName();
	
	public String email=fake.internet().emailAddress();
	
public void clickcreatenewuser() {
createnewuser.click();
}

public String getexistuser() throws InterruptedException {
	Thread.sleep(5000);
String text=existuser.getText();
return text;

}

public void clicksave() throws Exception {
	Thread.sleep(2000);
save.click();
Thread.sleep(4000);
}
public void cliccancel() throws Exception {
	Thread.sleep(2000);
cancel.click();

}

	public void Fullname() {
		UserFullName.sendKeys(fakename);
				
			}
	public void email() {
		Usermail.sendKeys(email);
				
			}

	public void selectRole() throws Exception {
		userRoleDrop.click();
		Thread.sleep(2000);
		SelectUserRole.click();
		
	}
	public void selectclient() throws Exception {
	clientDrop.click();
		Thread.sleep(2000);
		selectclient.click();
		Thread.sleep(2000);
	}

}
