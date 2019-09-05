package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPOM {
	
private WebDriver driver;
	
	public AddProductPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	//Demo
		
	@FindBy(xpath="//span[@class='tb_text' and text()='Information']")
	private WebElement ln_Information;
	
	@FindBy(xpath="//div[@class='swiper-slide']//div[@class='product-thumb product-thumb_style1']//div//a[contains(text(),'Integer Vitae Iaculis Massa')]")
	private WebElement ln_IntegerVitale;
	
	@FindBy(id="button-cart")
	private WebElement ln_AddtoCart;

	@FindBy(id="cart")
	private WebElement ln_Cart;
	
	@FindBy(xpath="//div[@class='checkout buttons']/a")
	private WebElement ln_ViewCart;
	
	
	public void fn_scrollToInformation(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ln_Information);
	}
	
	public void fn_ClickIntegerVitale(){
		WebDriverWait newWait = new WebDriverWait(driver, 30);
		WebElement locatePurchase = newWait.until(ExpectedConditions.visibilityOf(ln_IntegerVitale));
		locatePurchase.click();
	}
	
	public void fn_ClickAddtoCart(){
		this.ln_AddtoCart.click();
	}
	
	public void fn_MovetoCart(){
		Actions action = new Actions(driver);
		action.moveToElement(this.ln_Cart).build().perform();
	}
	
	public void fn_ClickViewCart(){
		this.ln_ViewCart.click();
	}

}
