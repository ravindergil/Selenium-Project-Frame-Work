package com.training.sanity.tests.pack2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.pom.AddCategoryPOM;
import com.training.pom.AdminLogInPOM;
import com.training.pom.EditMetaTagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditMetaTagTest {
	
	private WebDriver driver;
	private Properties properties;
	private AdminLogInPOM AdminLogIn;
	private AddCategoryPOM AddCategory;
	private EditMetaTagPOM EditMetaTag;
	private String baseUrl;
	private By locator = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]");
	private String ExpectedValue = "ORNAMENTS1";
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AdminLogIn = new AdminLogInPOM(driver); 
		AddCategory = new AddCategoryPOM(driver);
		EditMetaTag = new EditMetaTagPOM(driver);
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
	public void EditMetaData() throws InterruptedException {
		AdminLogIn.fn_senduserName("admin");
		AdminLogIn.fn_sendpassWord("admin@123");
		AdminLogIn.fn_clickLogIn();
		AddCategory.fn_CheckLogIn();
		AddCategory.fn_moveToCategories();
		Thread.sleep(1000);
		AddCategory.fn_VerifyCatagoryList();
		Thread.sleep(2000);
		EditMetaTag.getCellIndex(locator, ExpectedValue);
		EditMetaTag.fn_sendMetaTitle("ORNAMENTS");
		EditMetaTag.fn_sendMetaDescription("ornaments for ladies");
		AddCategory.fn_clickDataTab();
		AddCategory.fn_clickDesignTab();
		Thread.sleep(1000);
		AddCategory.fn_clickSaveButton();
		AddCategory.fn_verifySuccessMessage();
		
	}
	
	
	

}
