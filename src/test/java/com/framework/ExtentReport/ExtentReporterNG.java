package com.framework.ExtentReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.framework.Base.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
WebDriver driver;
ScreenshotListener sl=new ScreenshotListener();
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extent = new ExtentReports(System.getProperty("user.dir") + "/HTMLReports/HTML-Extent-Report.html", true);
		extent.addSystemInfo("Host Name", "SoftwareTestingMaterial").addSystemInfo("Environment", "Quality Agents Automation Testing")
        .addSystemInfo("User Name", "Ayesha ");
		  extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				try {
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
					 
					
				} catch (Exception e) {
					
					// TODO Auto-generated catch block
					System.out.println("Exception while taking screenshot "+e.getMessage());
				}
				try {
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		extent.flush();
		extent.close();
	}


    


	private void buildTestNodes(IResultMap tests, LogStatus status) throws Exception {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				 if (result.getStatus() == ITestResult.FAILURE) {
			            test.log(status, "Test Case is Failed " + result.getName());
			            test.log(status, "We found this error" + result.getThrowable());
			            // To capture screenshot path and store the path of the screenshot in the string
			            // "screenshotPath"
			            // We do pass the path captured by this mehtod in to the extent reports using
			            // "logger.addScreenCapture" method.
			           
			            //String screenshotPath = CaptureScreenshots.getScreenhot(driver,  result.getName());
						// To add it in the extent report
			        	 String dateName = new SimpleDateFormat("dd MM yyyy").format(new Date());
			            String destination = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + " " + dateName
			                     + ".png";
			          test.log(status, test.addScreenCapture(destination));
			           
			        } else if (result.getStatus() == ITestResult.SUCCESS) {
			            test.log(status, "Test Case Passed is " + result.getName());
			        } else {
			            test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			        }

				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}