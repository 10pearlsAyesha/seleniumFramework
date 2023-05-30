package com.framework.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Base.BaseClass;
import com.framework.pageObject.CreatClient;
import com.framework.pageObject.CreateUser;
import com.framework.pageObject.NewValidation;
import com.framework.utilites.ReadClientConfig;
import com.github.javafaker.Faker;

public class StartNewValidation extends BaseClass {
	Faker fake = new Faker();
	ReadClientConfig readclientconfig = new ReadClientConfig();
	// public Name name = fake.name();
	/*
	 * public Address adress = fake.address(); public String poc =
	 * readclientconfig.getpoc(); public PhoneNumber phone = fake.phoneNumber();
	 * //public String img = readclientconfig.getimagepath();
	 */
ValidationUser_Login login = new ValidationUser_Login();
SystemSpecifications_Form form= new  SystemSpecifications_Form();

	@Test
	public void startvalidation() throws Exception {
		login.ValidationLogin();
	   // Thread.sleep(5000);
		NewValidation nv = new NewValidation(driver);
		nv.start_new_validation();
		nv.SelectIOPQ();
		logger.info("Select IQ protocol");
	    nv.Validationname();
		logger.info("Entered Validation name");
		System.out.print(nv.fakename);
		nv.selecttype();
		logger.info("Equipment tyoe is selected");
		nv.selectid();
		logger.info("Equipment is selected");
		nv.clickinitiate_quliafication();
	    Thread.sleep(5000);
	    form.systemSpecificationForm();
	    Thread.sleep(5000);
	    
	
		

	}
}
