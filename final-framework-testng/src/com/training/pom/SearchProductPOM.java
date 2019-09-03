package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchProductPOM {
	
	private WebDriver driver;
	
	public SearchProductPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_button")
	private WebElement ln_clickSearch;
	
	@FindBy(id="filter_keyword")
	private WebElement ln_sendFilterKeys;
	
	@FindBy(xpath="//div[@class='sort']/select")
	private WebElement ln_clickSelectSort;
	

	
	public void fn_clickSearch() {
		this.ln_clickSearch.click();
	}
	
	public void fn_sendFilterKeys(String filterKeys) {
		this.ln_sendFilterKeys.sendKeys(filterKeys);
	}
	
	public void fn_clickSelectSort() {
		this.ln_clickSelectSort.click();
	}
	
	public void fn_SelectNameAZ() {
		Select select = new Select(ln_clickSelectSort);
		List <WebElement> SelectOptions = select.getOptions();
		for(WebElement Option:SelectOptions) {
			System.out.println(Option.getText());
		}
		select.selectByVisibleText("Name (A - Z)");
	}
	
	public void fn_SelectRatingHighest() {
		Select select = new Select(ln_clickSelectSort);
		select.selectByVisibleText("Rating (Highest)");
	}
}
