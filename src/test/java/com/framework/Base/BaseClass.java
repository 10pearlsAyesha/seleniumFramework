
package com.framework.Base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.ExtentReport.ScreenshotListener;
import com.framework.utilites.ReadConfig;


//
@Listeners(ScreenshotListener.class)
public class BaseClass{
	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getpassword();
	public String valusername=readconfig.getValUsername();
	public String vapassword=readconfig.getValpassword();
	public static WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
  
	public static Logger logger;
	// setup method
	@Parameters("browser")

	@BeforeClass
	public void setup(String br) {
		
	logger=Logger.getLogger("Project name");
	PropertyConfigurator.configure("log4j.properties");	
	if(br.equals("chrome")) {
		//incognito parameter passed

	System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");

	driver= new ChromeDriver(options);
	
	
	
	}
	else if(br.equals("edge")) {
		System.setProperty("webdriver.edge.driver",readconfig.getedgepath());
		driver= new EdgeDriver();
		}

	}
	
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
		
	}
	
	/*@BeforeTest
	public void startReport(){
	//ExtentReports(String filePath,Boolean replaceExisting)
	//filepath - path of the file, in .htm or .html format - path where your report needs to generate.
	//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
	//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
	//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
	extent = new ExtentReports (System.getProperty("user.dir") +"/HTMLReports/STMExtentReport.html", true);
	//extent.addSystemInfo("Environment","Environment Name")
	extent
	                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
	                .addSystemInfo("Environment", "Automation Testing")
	                .addSystemInfo("User Name", "Ayesha ");
	                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
	                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
	                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	 
	        //This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
	String dateName = new SimpleDateFormat("yyyyMMdd").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = System.getProperty("user.dir") + "/Screenshots/"+screenshotName+" "+dateName+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
	if(result.getStatus() == ITestResult.FAILURE){
		test.log(LogStatus.FAIL,"Test Case is Failed " +result.getName());
		test.log(LogStatus.FAIL, "We found this error"+result.getThrowable());
	//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method.
	                        String screenshotPath = BaseClass.getScreenhot(driver, result.getName());
	//To add it in the extent report
	                        test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
	}else if(result.getStatus() == ITestResult.SKIP){
		test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	}
	// ending test
	//endTest(logger) : It ends the current test and prepares to create HTML report
	extent.endTest(test);
	}
	@AfterTest
	public void endReport(){
	// writing everything to document
	//flush() - to write or update test information to your report.
	                extent.flush();
	                //Call close() at the very end of your session to clear all resources.
	                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
	                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream.
	                //Once this method is called, calling any Extent method will throw an error.
	                //close() - To close all the operation
	                extent.close();
	    }*/
	}