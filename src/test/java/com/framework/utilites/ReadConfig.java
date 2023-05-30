package com.framework.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src = new File("./Configurations\\config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Exception is " + e.getLocalizedMessage());
		}
	}
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		String uname=pro.getProperty("username");
		return uname;
	}
	public String getpassword() {
		String pass=pro.getProperty("password");
		return pass;
	}
	public String getValUsername() {
		String valuname=pro.getProperty("validationuser");
		return valuname;
	}
	public String getValpassword() {
		String valpass=pro.getProperty("valpassword");
		return valpass;
	}
	public String getChromepath() {
		String chropath=pro.getProperty("Chromepath");
	
		return chropath;
	}
	public String getedgepath() {
		// TODO Auto-generated method stub
		String edgepath=pro.getProperty("Edgepath");
		return edgepath;
	}
	public String getNo() {
		// TODO Auto-generated method stub
		String no=pro.getProperty("Phone");
		return no;
	}

}
