package com.framework.testCase;

import org.testng.annotations.Test;

import com.framework.Base.BaseClass;
import com.framework.pageObject.SystemSpecifications;
import com.framework.utilites.ReadClientConfig;

public class SystemSpecifications_Form extends BaseClass {
	
	ReadClientConfig readclientconfig = new ReadClientConfig();
	// public Name name = fake.name();
	/*
	 * public Address adress = fake.address(); public String poc =
	 * readclientconfig.getpoc(); public PhoneNumber phone = fake.phoneNumber();
	 * //public String img = readclientconfig.getimagepath();
	 */
	//TC_LoginPage_001 login = new TC_LoginPage_001();

	@Test
	public void systemSpecificationForm() throws Exception {
		//login.loginTest();
		
		SystemSpecifications ss = new SystemSpecifications(driver);
		//Select non-gxp radio button
		ss.NonGXP();
		logger.info("Non-GXP is selected");
		ss.Location();
		logger.info("Location value is entered");
		ss.Room();
		logger.info("Room value is entered");
		/*ss.clickaddanother();
		logger.info("Clicked addAnotherbtn");
		ss.Setpoints();
		logger.info("Setpoints are entered");*/
		ss.Criteria();
		logger.info("Criteria is selected");
		ss.Fileupload();
		logger.info("File is uploaded");
		ss.filecomment();
		logger.info("File is uploaded");
		ss.comment();
		logger.info("Comment value is entered");
		
	ss.Save();
	logger.info("Clicked on saved button");
	ss.ScrollUp();
	Thread.sleep(5000);
		
	}
}
