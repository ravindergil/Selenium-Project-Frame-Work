package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditMetaTagPOM {
	
	private WebDriver driver;
	
	public EditMetaTagPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-meta-title1")
	private WebElement ln_metaTitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement ln_metaDescription;
	
	
	public void getCellIndex(By locator, String ExpectedValue) {
		int i;
		List<WebElement> cellData = driver.findElements(locator);
		for(i=0; i<cellData.size(); i++) {
			String cellText = cellData.get(i).getText().trim();
			
			if(cellText.equals(ExpectedValue)) {
				int a = i+1;
				WebElement clickEditButton = 
						driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr[" + a + "]/td[4]/a/i"));
				System.out.println(clickEditButton.getText() + " clicked");
				clickEditButton.click();
				break;
			}
		}
	}
	
	public void fn_sendMetaTitle(String MetaTitle) {
		this.ln_metaTitle.clear();
		this.ln_metaTitle.sendKeys(MetaTitle);
	}
	
	public void fn_sendMetaDescription(String MetaDescription) {
		this.ln_metaDescription.clear();
		this.ln_metaDescription.sendKeys(MetaDescription);
	}
	

}
