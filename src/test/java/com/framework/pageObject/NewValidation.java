package com.framework.pageObject;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;


public class NewValidation {

	WebDriver ldriver;
	public NewValidation(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	Faker fake=new Faker();
	@FindBy(xpath ="//span[text()=\"Start New Validation\"]")
	@CacheLookup
	WebElement startnewvalidation_btn;
	
	
	@FindBy(xpath ="//*[@id=\"validationForm\"]/div[2]/div/div[2]/div/div/input")
	@CacheLookup
	WebElement ValidationName;
	@FindBy(xpath ="//span[text()=\"IOPQ\"]")
	@CacheLookup
	public
	WebElement IOPQ;
	@FindBy(xpath ="//*[@id=\"rc_select_1\"]")
	@CacheLookup
	WebElement Equipment_type;
	@FindBy(xpath ="//*[@id=\"rc_select_2\"]")
	@CacheLookup
	WebElement Equipement_id;
	@FindBy(xpath ="//div/div[text()=\"Refrigerator\"]")
	@CacheLookup
	WebElement select_equioment_type;
	@FindBy(xpath ="//div[text()=\"Test 1\"]")
	@CacheLookup
	WebElement select_equioment_id;
	@FindBy(xpath ="//span[text()='Initiate Qualification']")
	@CacheLookup
	WebElement Initiate_Qualifiaction;
	/*@FindBy(xpath ="//*[@id=\"adminForm\"]/div[11]/div/div/div/div/div/div[2]/button/span")
	@CacheLookup
	WebElement cancel;
	@FindBy(xpath ="//*[@id=\"rc-tabs-1-panel-all-users-listing\"]/div/div[2]/div/div/div[1]/div/div/div/div/div[2]/table/tbody/tr[2]/td[1]/div")
	@CacheLookup
	WebElement existuser;*/
	public String fakename=fake.name().firstName();
	
	
public void start_new_validation() {
	startnewvalidation_btn.click();
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

/*public String getexistuser() throws InterruptedException {
	Thread.sleep(5000);
String text=existuser.getText();
return text;

}*/

public void clickinitiate_quliafication() throws Exception {
	
	Initiate_Qualifiaction.click();
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
}
/*public void cliccancel() throws Exception {
	Thread.sleep(2000);
cancel.click();

}*/

	public void Validationname() {
		ValidationName.sendKeys(fakename);
		ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
				
			}
	public void SelectIOPQ() {
		IOPQ.click();
		ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
			}

	@SuppressWarnings("deprecation")
	public void selecttype() throws Exception {
		Equipment_type.click();
		ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//to perform Scroll on application using Selenium
	
	select_equioment_type.click();
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@SuppressWarnings("deprecation")
	public void selectid() throws Exception {
		Equipement_id.click();
		ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	select_equioment_id.click();
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
