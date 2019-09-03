package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.SearchProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SearchProductTest {
	
	protected WebDriver driver;
	private String baseUrl;
	private SearchProductPOM SearchProduct;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		SearchProduct = new SearchProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
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
	public void validLoginTest() throws InterruptedException {
		SearchProduct.fn_clickSearch();
		SearchProduct.fn_sendFilterKeys("Finger Ring");
		SearchProduct.fn_clickSearch();
		Thread.sleep(3000);
		SearchProduct.fn_clickSelectSort();
		Thread.sleep(3000);
		SearchProduct.fn_SelectNameAZ();
		Thread.sleep(3000);
		SearchProduct.fn_SelectRatingHighest();
		screenShot.captureScreenShot("First");
	}

}
