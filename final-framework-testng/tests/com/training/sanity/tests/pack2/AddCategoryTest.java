package com.training.sanity.tests.pack2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.pom.AddCategoryPOM;
import com.training.pom.AdminLogInPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategoryTest {
	
	private WebDriver driver;
	private Properties properties;
	private AdminLogInPOM AdminLogin;
	private AddCategoryPOM AddCategory;
	private String baseUrl;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AdminLogin = new AdminLogInPOM(driver); 
		AddCategory = new AddCategoryPOM(driver);
		baseUrl = properties.getProperty("adminURL");
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void AdminCategoryTest() throws InterruptedException {
		AdminLogin.fn_senduserName("admin");
		AdminLogin.fn_sendpassWord("admin@123");
		AdminLogin.fn_clickLogIn();
		Thread.sleep(1000);
		AddCategory.fn_CheckLogIn();
		AddCategory.fn_moveToCategories();
		Thread.sleep(1000);
		AddCategory.fn_VerifyCatagoryList();
		Thread.sleep(2000);
		AddCategory.fn_clickAddbutton();
		Thread.sleep(1000);
		AddCategory.fn_enterCategoryName("ORNAMENTS1");
		AddCategory.fn_enterCategoryDescription("ornaments for ladies");
		AddCategory.fn_enterMetaTag("ORNAMENTS1");
		AddCategory.fn_enterMetaDescription("ornaments for ladies");
		Thread.sleep(1000);
		AddCategory.fn_clickDataTab();
		Thread.sleep(1000);
		AddCategory.fn_clickDesignTab();
		Thread.sleep(1000);
		AddCategory.fn_clickSaveButton();
		AddCategory.fn_verifySuccessMessage();
		
	}

}
