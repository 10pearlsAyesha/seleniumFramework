package com.framework.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Base.BaseClass;
import com.framework.pageObject.CreatClient;
import com.framework.utilites.ReadClientConfig;
import com.github.javafaker.Faker;

public class TC_CreateClient extends BaseClass {
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
	public void creatclient() throws Exception {
		login.loginTest();
		CreatClient cc = new CreatClient(driver);

		cc.clickclienttab();
		Thread.sleep(2000);
		cc.clicknewclient();
		Thread.sleep(2000);

		cc.setclienet();
		logger.info("Entered client name");
		Thread.sleep(2000);
		System.out.print(cc.fakename);
		cc.setaddress();
		logger.info("Entered client address");
		System.out.print(cc.fadress);
// click on dropdown flag
		cc.selectcountrycode();

		cc.setno();
		logger.info("Entered client no");
		System.out.print(cc.fno);
		cc.setpoc();
		logger.info("Entered Client POC");
		System.out.print(cc.fpoc);
		Thread.sleep(2000);
		cc.clickcreate();
		Thread.sleep(2000);
		cc.clickcancelbtn();
		Thread.sleep(2000);

		String text = cc.getexistclient();
		System.out.print(text);
		Thread.sleep(2000);

		if (text.equals(cc.fakename)) {
			Assert.assertTrue(true);
			logger.info("Client created successfully");
		} else {
			Assert.assertFalse(false);
			logger.info("Client doses not created");
		}

	}
}
