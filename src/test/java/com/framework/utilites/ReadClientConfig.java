package com.framework.utilites;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadClientConfig {
	Properties pro;
	public ReadClientConfig() {
		File src = new File("./Configurations\\clientconfig.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Exception is " + e.getLocalizedMessage());
		}
	}
	
	public String getClientname() {
		String Cname=pro.getProperty("ClientName");
		return Cname;
	}
	public String getimagepath() {
		String img=pro.getProperty("imagepath");
		return img;
	}
	public String getClientaddress() {
		String adress=pro.getProperty("ClientAdress");
		return adress;
	}
	public String getpoc() {
		String poc=pro.getProperty("Poc");
	
		return poc;
	}
	public String getNo() {
		// TODO Auto-generated method stub
		String no=pro.getProperty("Phone");
		return no;
	}

}
