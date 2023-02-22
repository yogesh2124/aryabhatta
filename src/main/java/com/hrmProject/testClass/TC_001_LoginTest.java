package com.hrmProject.testClass;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hrmProject.PageObjectClass.BaseClass;
import com.hrmProject.PageObjectClass.loginPageClass;
import com.hrmProject.utilities.exceldata;

public class TC_001_LoginTest  extends BaseClass{
	
	@BeforeMethod
	public void initialization() {
	setup();
	}
	
	@Test
	
	public void loginverify() throws Throwable {
		//driver.get(baseURL);
		
		try {
			
		loginPageClass login= new loginPageClass(driver);
		Thread.sleep(2000);
			
		test = extent.createTest("vrerify application login");

	login.setusername(exceldata.getdata(2, 0));
		login.setusername(username); test.log(Status.PASS, "username successfully entered");
		Thread.sleep(2000);
		login.setpassword(password); test.log(Status.PASS, "password successfully entered");
		Thread.sleep(2000);
		login.clickonloginbutton(); test.log(Status.PASS, "logged in successfully ");

		String expectedtitle = "GTPL Bank Home Page";
	    String   actualtitle = driver.getTitle();
	    System.out.println(driver.getTitle());
		
        if(actualtitle.equals(expectedtitle)) {
			test.log(Status.PASS, "succesfully loged in");
		}else {
			test.log(Status.FAIL, " failed");
		    String screenshotpath = BaseClass.captureScreen();
		    test.addScreenCaptureFromPath(screenshotpath);
		}
        
	 
}
		
catch (Exception e){
		test.log(Status.FAIL, " failed");
	    String screenshotpath = BaseClass.captureScreen();
	    test.addScreenCaptureFromPath(screenshotpath);
	}
	}
	
	@AfterMethod
	public void shutbrowser() throws Throwable {
		Thread.sleep(2000);
		closebrowser();
	}
	  
	
}



