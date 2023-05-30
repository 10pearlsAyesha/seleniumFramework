package com.framework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class CreatClient {
	private String firstName;
	WebDriver ldriver;
	public CreatClient(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	Faker fake=new Faker();
	@FindBy(xpath ="//*[@id=\"clientForm\"]/div[11]/div/div/div/div/div/div[1]/button/span")
	@CacheLookup
	WebElement createbtn;
	@FindBy(xpath ="//div[text()='Clients']")
	@CacheLookup
	WebElement clientTab;
	@FindBy(xpath= "//span[text()='Create New Client']")
	@CacheLookup
	WebElement creatnewclient;
	
	@FindBy(xpath ="//*[@id=\"clientForm_address\"]")
	@CacheLookup
	WebElement clientaddress;
	@FindBy(xpath ="//*[@id=\"clientForm_name\"]")
	@CacheLookup
	public
	WebElement clientname;
	@FindBy(xpath ="//*[@id=\"clientForm_poc\"]")
	@CacheLookup
	WebElement clientpoc;
	@FindBy(xpath ="//*[@id=\"clientForm\"]/div[7]/div/div[2]/div/div/div/input")
	@CacheLookup
	WebElement clientno;
	@FindBy(xpath ="//span[text()=\"Cancel\"]")
	@CacheLookup
	WebElement cancelbtn;
	@FindBy(xpath ="//tbody[@class='ant-table-tbody']/tr[2]/td[1]")
	@CacheLookup
	WebElement existclient;
	@FindBy(xpath ="//span[text()='Upload']")
	@CacheLookup
	WebElement upload;
	@FindBy(xpath ="//span[text()=\"Pakistan\"]")
	@CacheLookup
	WebElement selectcountry;
	@FindBy(xpath ="//*[@id=\"clientForm\"]/div[7]/div/div[2]/div/div/div/div[2]/div")
	@CacheLookup
	WebElement countrydrop;
	public String fakename=fake.name().firstName();
	public String fpoc=fake.name().title();
	public String fadress=fake.address().country();
	public String fno=fake.phoneNumber().cellPhone();
public void clickclienttab() {
clientTab.click();
}
public String getexistclient() {
String text=existclient.getText();
return text;

}

public void clickcancelbtn() {
cancelbtn.click();
}
public void clicknewclient() {
creatnewclient.click();
}
	public void setclienet() {
clientname.sendKeys(fakename);
		
	}
	public void uploadimg() {
	upload.click();
				
			}
	public void uploadimg2(CharSequence[] image) {
		upload.sendKeys(image);
		
					
				}
	public void setaddress() {
		clientaddress.sendKeys(fadress);
				
			}
	public void setno() {
		clientno.sendKeys(fno);
				
			}
	public void setpoc() {
		clientpoc.sendKeys(fpoc);
				
			}
	public void clickcreate() {
		createbtn.click();
	}
	public void selectcountrycode() throws Exception {
		countrydrop.click();
		Thread.sleep(2000);
		selectcountry.click();
		Thread.sleep(2000);
	}

}
