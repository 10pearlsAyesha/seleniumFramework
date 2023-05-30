package com.framework.pageObject;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;


public class SystemSpecifications {

	WebDriver ldriver;
	public SystemSpecifications(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	String ECD="Test1";
	String room="Room1";
	String location="Location1";
	String setpoin="45";
	String range="50 to 60";
	String comnt="This is my test Comment";
	String filecomnt="This is my attachment comment";
	String filepath="/Seleniume-Framework/src/test/resources/two.pdf";
	@FindBy(xpath ="//*[@id=\"nest-messages\"]/div/div/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/label[2]/span[2]")
	@CacheLookup
	WebElement EquipmentClassification;
	
	@FindBy(xpath ="//input[@name=\"equipmentClassificationval\"]")
	@CacheLookup
	WebElement EquipmentClassField;
	@FindBy(xpath ="//input[@name=\"location\"]")
	@CacheLookup
	WebElement Location;
	@FindBy(xpath ="//input[@name=\"room\"]")
	@CacheLookup
	WebElement Room;
	@FindBy(xpath ="//span[text()=\"+ Add Another Setpoint\"]")
	@CacheLookup
	WebElement AddAnOtherButton;
	@FindBy(xpath ="//input[@name=\"setPointtemperatureAcceptableRanges1\"]")
	@CacheLookup
	WebElement Setpoint;
	@FindBy(xpath ="//input[@name=\"acceptableRangetemperatureAcceptableRanges1\"]")
	@CacheLookup
	WebElement AcceptableRange;
	@FindBy(xpath ="//span[text()=\"Yes\"]")
	@CacheLookup
	WebElement CriteriaMet;
	@FindBy(xpath ="//*[@id=\"nest-messages\"]/div/div/div/div/div[12]/div/div/div/div[2]/div/div/div/span/textarea")
	@CacheLookup
	WebElement Comment;
	@FindBy(xpath ="//span[text()=\"Save\"]")
	@CacheLookup
	WebElement SaveBtn;
	@FindBy(xpath ="//button[@class='ant-btn ant-btn-primary']")
	@CacheLookup
	WebElement UploadFile;
	@FindBy(xpath ="//input[@name=\"fileComments0\"]")
	@CacheLookup
	WebElement FileComent;
	
	
public void NonGXP() {
	EquipmentClassification.click();
	ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	EquipmentClassField.sendKeys(ECD);
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void Location() {
	Location.click();
	ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
Location.sendKeys(location);
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void Room() {
	Room.click();
	ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
Room.sendKeys(room);
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void clickaddanother() {
AddAnOtherButton.click();
ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void Setpoints() {
	Setpoint.click();
	ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
Setpoint.sendKeys(setpoin);
	AcceptableRange.click();
	ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	AcceptableRange.sendKeys(range);
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void Criteria() {
CriteriaMet.click();
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void comment() {
Comment.click();
	ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	Comment.sendKeys(comnt);
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void Fileupload() throws InterruptedException, Exception {
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//UploadFile.click();
	/*ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
UploadFile.sendKeys("/Seleniume-Framework/src/test/resources/one.pdf");*/
	UploadFile.click(); // Click on browse option on the webpage
	    Thread.sleep(2000); // suspending execution for specified time period
	 
	    // creating object of Robot class
	    Robot rb = new Robot();
	 
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("C:\\Users\\Ayesha Alloudin\\eclipse-workspace\\Seleniume-Framework\\src\\test\\resources\\one.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
}
public void filecomment() {
FileComent.click();
	ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	FileComent.sendKeys(filecomnt);
	ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void Save() {
SaveBtn.click();
	ldriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
}
public void ScrollUp() {
	//to perform Scroll on application using Selenium
	JavascriptExecutor js = (JavascriptExecutor) ldriver;
    js.executeScript("window.scrollBy(0,-500)", "");
	
}

}
