package com.framework.testCase;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Base.BaseClass;
import com.framework.pageObject.CreateUser;
import com.framework.utilites.ReadClientConfig;
import com.github.javafaker.Faker;

public class TC_CreateUser extends BaseClass {
	Faker fake = new Faker();
	ReadClientConfig readclientconfig = new ReadClientConfig();
	// public Name name = fake.name();
	/*
	 * public Address adress = fake.address(); public String poc =
	 * readclientconfig.getpoc(); public PhoneNumber phone = fake.phoneNumber();
	 * //public String img = readclientconfig.getimagepath();
	 */
	TC_LoginPage_001 login = new TC_LoginPage_001();

	@Test
	public void creatUser() throws Exception {
		login.loginTest();
		CreateUser cu = new CreateUser(driver);

		cu.clickcreatenewuser();
		Thread.sleep(2000);
		cu.Fullname();
		logger.info("Entered user name");
		Thread.sleep(2000);
		System.out.print(cu.fakename);
		cu.email();
		logger.info("Entered user email");
		System.out.print(cu.email);
		cu.selectRole();
		logger.info("user role selected");
		cu.selectclient();
		logger.info("client is selected");
		cu.clicksave();
		cu.cliccancel();
		driver.navigate().refresh();
		String text = cu.getexistuser();
		System.out.print(text);
		Thread.sleep(2000);

		if (text.equals(cu.fakename)) {
			Assert.assertTrue(true);
			logger.info("Client created successfully");
		} else {
			Assert.assertFalse(false);
			logger.info("Client doses not created");
		}

	}
}
