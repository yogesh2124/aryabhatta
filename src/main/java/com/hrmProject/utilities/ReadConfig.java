package com.hrmProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	    public ReadConfig(){  //file format 
		File src = new File("C:\\Users\\yoges\\eclipse-workspace\\ADMIN_PROJECT01\\properties\\config.properties");
		try {
		FileInputStream file = new FileInputStream(src);  //input format
		 pro = new Properties();    //objet=creation of properties
		pro.load(file);               //load methods
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		 

	}
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getusername() {
		String username = pro.getProperty("username");
		return username;


	}
	
	public String getpassword() {
		String password = pro.getProperty("password");
		return password;


	}
}
