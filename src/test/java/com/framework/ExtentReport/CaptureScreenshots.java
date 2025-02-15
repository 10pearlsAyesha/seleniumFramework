package com.framework.ExtentReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CaptureScreenshots {
	// This method is to capture the screenshot and return the path of the
    // screenshot.
    public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("dd MM yyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src
        // folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + " " + dateName
                + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

}
