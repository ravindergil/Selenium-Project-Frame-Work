package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.HandleEvents;
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
	private EventFiringWebDriver eDriver;
	private HandleEvents handleEvent;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		
		eDriver = new EventFiringWebDriver(driver);
		handleEvent = new HandleEvents();
		eDriver.register(handleEvent);
		
		AddProd = new AddProductPOM(eDriver); 
		screenShot = new ScreenShot(eDriver); 
		// open the browser 
		eDriver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		eDriver.quit();
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
