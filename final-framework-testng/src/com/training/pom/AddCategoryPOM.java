package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AddCategoryPOM {
	
	private WebDriver driver;
	private Actions action;
	
	public AddCategoryPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="li#menu-catalog>a>i")
	private WebElement ln_menuCatalog;
	
	@FindBy(css="li#menu-catalog>ul>li>a")
	private WebElement ln_Categories;
	
	@FindBy(xpath="//table/thead/tr")
	private WebElement ln_TableRow;
	
	@FindBy(css="div.pull-right>a>i.fa.fa-plus")
	private WebElement ln_AddButton;
	
	@FindBy(id="input-name1")
	private WebElement ln_categoryName;
	
	@FindBy(css="div.note-editable.panel-body")
	private WebElement ln_Description;
	
	@FindBy(id="input-meta-title1")
	private WebElement ln_MetaTag;
	
	@FindBy(id="input-meta-description1")
	private WebElement ln_metaDescription;
	
	@FindBy(xpath="//div[@class='panel-body']//*[text()='Data']")
	private WebElement ln_DataTab;
	
	@FindBy(xpath="//div[@class='panel-body']//*[text()='Design']")
	private WebElement ln_Design;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement ln_SaveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success'][contains(text(),'Success: You have modified categories!')]")
	private WebElement ln_SuccessMessage;
	
	
	
	public void fn_CheckLogIn() {
		String Actual = driver.getTitle();
		String Expected = "Dashboard";
		Assert.assertEquals(Actual, Expected);
	}
	
	public void fn_moveToCategories() {
		action = new Actions(driver);
		action.moveToElement(ln_menuCatalog).click(ln_Categories).build().perform();
	}
	
	public void fn_VerifyCatagoryList() {
		String ActualText = this.ln_TableRow.getText();
		String ExpectedText = "Category Name Sort Order Action";
		Assert.assertEquals(ActualText, ExpectedText);
	}
	
	public void fn_clickAddbutton() {
		ln_AddButton.click();
	}
	
	public void fn_enterCategoryName(String categoryName) {
		ln_categoryName.clear();
		ln_categoryName.sendKeys(categoryName);
	}
	
	public void fn_enterCategoryDescription(String description) {
		ln_Description.clear();
		ln_Description.sendKeys(description);
	}
	
	public void fn_enterMetaTag(String metaTagText) {
		ln_MetaTag.clear();
		ln_MetaTag.sendKeys(metaTagText);
	}
	
	public void fn_enterMetaDescription(String metaDescription) {
		ln_metaDescription.clear();
		ln_metaDescription.sendKeys(metaDescription);
		action.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP);
		
	}
	
	public void fn_clickDataTab() {
		ln_DataTab.click();
	}
	
	public void fn_clickDesignTab() {
		ln_Design.click();
	}
	
	public void fn_clickSaveButton() {
		ln_SaveButton.click();
	}
	
	public void fn_verifySuccessMessage() {
		String [] arr = ln_SuccessMessage.getText().split("\n");
		String ActualText = arr[0].trim();
		String ExpectedText = "Success: You have modified categories!";
		Assert.assertEquals(ActualText, ExpectedText);
	}
	
}
