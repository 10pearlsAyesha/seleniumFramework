package com.framework.testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.framework.Base.BaseClass;

public class FileUpload extends BaseClass {
	 
	   // TODO Auto-generated method stub
	@Test
	public void UploadTest() throws InterruptedException {
	   driver.manage().window().maximize(); //always write wait code after this
	   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
	   driver.get("https://www.monsterindia.com/seeker/registration"); //Testing webpage
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //for Implicit wait
	 
	   JavascriptExecutor js = (JavascriptExecutor) driver; //Scrolling using JavascriptExecutor
	   js.executeScript("window.scrollBy(0,380)");//Scroll Down to file upload button (+ve)
	   Thread.sleep(3000);
	 
	   // FILE UPLOADING USING SENDKEYS ....
	 
	   WebElement browse =  driver.findElement(By.xpath("//input[@id='file-upload']"));
	   //click on ‘Choose file’ to upload the desired file
	   browse.sendKeys("/Seleniume-Framework/src/test/java/com/framework/testData/Images/Profile.jpg"); //Uploading the file using sendKeys
	   System.out.println("File is Uploaded Successfully");
	 
	}
	 
	}