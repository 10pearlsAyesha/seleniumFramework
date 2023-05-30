package com.framework.ExtentReport;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.framework.Base.BaseClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenshotListener extends TestListenerAdapter {

   // private static final Logger LOG = (Logger) LogManager.getLogger(ScreenshotListener.class);
BaseClass bs=new BaseClass();
    private boolean createFile(File screenshot) {
        boolean fileCreated = false;

        if (screenshot.exists()) {
            fileCreated = true;
        } else {
            File parentDirectory = new File(screenshot.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdirs()) {
                try {
                    fileCreated = screenshot.createNewFile();
                } catch (IOException errorCreatingScreenshot) {
                	System.out.printf("Unable to create " + screenshot.getAbsolutePath(), errorCreatingScreenshot);
                }
            }
        }

        return fileCreated;
    }

    private void writeScreenshotToFile(WebDriver driver, File screenshot) {
        try {
            FileOutputStream screenshotStream = new FileOutputStream(screenshot);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        } catch (IOException unableToWriteScreenshot) {
        	System.out.printf("Unable to write to " + screenshot.getAbsolutePath(), unableToWriteScreenshot);
        }
    }

    @Override
    public void onTestFailure(ITestResult failingTest) {
        try {
        	 String dateName = new SimpleDateFormat("dd MM yyyy").format(new Date());
        	 String destination = System.getProperty("user.dir") + "/Screenshots/" + failingTest.getName() + " " + dateName
                     + ".png";
           // String screenshotAbsolutePath = destination + File.separator + dateName + "_" + failingTest.getName() + ".png";
            File screenshot = new File(destination);
            if (createFile(screenshot)) {
                try {
                    writeScreenshotToFile(bs.driver, screenshot);
                } catch (ClassCastException weNeedToAugmentOurDriverObject) {
                    writeScreenshotToFile(new Augmenter().augment(bs.driver), screenshot);
                }
                System.out.printf("     Written screenshot to " + destination);
            }
        } catch (Exception ex) {
        	System.out.printf("Unable to capture screenshot...", ex);
        }
    }
}
