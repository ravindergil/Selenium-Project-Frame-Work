package com.training.sanity.tests.pack2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLogInPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLogInTest {
	
	private WebDriver driver;
	private String baseUrl;
	private AdminLogInPOM AdminloginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AdminloginPOM = new AdminLogInPOM(driver); 
		baseUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void AdminLoginTest() {
		AdminloginPOM.fn_senduserName("admin");
		AdminloginPOM.fn_sendpassWord("xuay123");
		AdminloginPOM.fn_clickLogIn();
		AdminloginPOM.fn_VerifyErrorMessage();
	}

}
