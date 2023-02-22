package com.hrmProject.PageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageClass {
	WebDriver ldriver;
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement Login;
	

	
	 
   public loginPageClass(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this );
	}
	public void setusername(String uname) {
		username.sendKeys(uname);
	}
	public void setpassword(String upass) {
		password.sendKeys(upass);
	}
	public void clickonloginbutton() {
		Login.click();
	}
	

	
}
