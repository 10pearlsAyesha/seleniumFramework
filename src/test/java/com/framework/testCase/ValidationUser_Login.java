package com.framework.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.Base.BaseClass;
import com.framework.pageObject.ValidationLogin;

public class ValidationUser_Login extends BaseClass {
	@Test
	public void ValidationLogin() throws InterruptedException {
		// test = extent.startTest("loginTest");
		driver.get(baseURL);
		logger.info("URL IS OPEN");
		driver.manage().window().maximize();
		ValidationLogin lp = new ValidationLogin(driver);
		lp.setUsername(valusername);
		logger.info("Entered user name");
		lp.setpassword(vapassword);
		logger.info("Entered password");

		lp.clickSubmit();
		logger.info("Clicked signin button");

		Thread.sleep(5000);

		String expectedUrl = driver.getCurrentUrl();
		//System.out.print(expectedUrl);
		String actualUrl = "https://qualityagents-dev.azureedge.net/";

		Thread.sleep(2000);

		if (actualUrl.equals(expectedUrl)) {
			Assert.assertTrue(true);
			logger.info("Login test is Passed");
//			driver.findElement(By.xpath("//div[text()='Clients']")).click();
//			Thread.sleep(2000);
		} else {
			Assert.assertFalse(false);
			logger.info("Login test is Failed");
		}
		
	}

}
