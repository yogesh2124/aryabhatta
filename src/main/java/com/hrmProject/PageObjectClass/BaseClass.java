package com.hrmProject.PageObjectClass;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrmProject.utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	
	public static ExtentSparkReporter sparkreport;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setReport() {
		sparkreport = new ExtentSparkReporter("C:\\Users\\yoges\\eclipse-workspace\\ADMIN_PROJECT01\\reports\\htmlreport1"+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		extent.setSystemInfo("Operating System","Windows");
		extent.setSystemInfo("Enveroment","QA");
		sparkreport.config().setReportName("Integration Test Execution");
		sparkreport.config().setDocumentTitle("QA Automation TEsting Report");
		sparkreport.config().setTheme(Theme.STANDARD);	
	}
	
	
	public void setup()
	{	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yoges\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe"); 
	 driver = new ChromeDriver();
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
	
	
	

	public void closebrowser() {
		driver.quit();	
	}
    
	@AfterSuite
	public void endReport() {
		extent.flush();
	}


	public static String captureScreen() throws IOException  {
		Random random = new Random();
		int x= random.nextInt(100);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dest = "C:\\Users\\yoges\\eclipse-workspace\\ADMIN_PROJECT01\\screenshot\\new"+".png";
		
		FileUtils.copyFile(source,new File(dest));
		return dest;	
		
	}

}