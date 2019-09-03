package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductTest {
	
	public static WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddProductPOM AddProd;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AddProd = new AddProductPOM(driver); 
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
	public void AddProduct() throws InterruptedException{
		AddProd.fn_scrollToInformation();
		AddProd.fn_ClickIntegerVitale();
		AddProd.fn_ClickAddtoCart();
		AddProd.fn_MovetoCart();
		AddProd.fn_ClickViewCart();
		
	}

}
