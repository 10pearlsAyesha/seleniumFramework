package com.framework.testCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Base.BaseClass;
import com.framework.pageObject.LoginPage;

public class TC_LoginPage_001 extends BaseClass {
	@Test
	public void loginTest() throws InterruptedException {
		// test = extent.startTest("loginTest");
		driver.get(baseURL);
		logger.info("URL IS OPEN");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered user name");
		lp.setpassword(password);
		logger.info("Entered password");

		lp.clickSubmit();
		logger.info("Clicked signin button");

		Thread.sleep(5000);

		String expectedUrl = driver.getCurrentUrl();
		//System.out.print(expectedUrl);
		String actualUrl = "https://qa-qualityagents.azureedge.net/";

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
