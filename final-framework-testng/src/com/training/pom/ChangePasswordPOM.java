package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChangePasswordPOM {
	
	private WebDriver driver;
	
	public ChangePasswordPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='System_nyHsmShk']/align/ul/li[2]/a")
	private WebElement ln_changePassword;
	
	@FindBy(css="input#input-password")
	private WebElement ln_enterPassword;
	
	@FindBy(css="input#input-confirm")
	private WebElement ln_confirmPassword;
	
	@FindBy(xpath="//input[@class='btn btn-primary'][contains(@type,'submit')]")
	private WebElement ln_clickContinue;
	
	@FindBy(xpath="//*[contains(text(),'Password confirmation does not match password!')]")
	private WebElement ln_errorText;
	
	public void fn_clickChangePassword(){
		this.ln_changePassword.click();
	}
	
	public void fn_enterPassword(String changedPassword){
		this.ln_enterPassword.clear();
		this.ln_enterPassword.sendKeys(changedPassword);
	}
	
	public void fn_enterConfirmPassword(String confirmNewPassword){
		this.ln_confirmPassword.clear();
		this.ln_confirmPassword.sendKeys(confirmNewPassword);
	}
	
	public void fn_clickContinue(){
		this.ln_clickContinue.click();
	}
	
	public void fn_checkErrorText(){
		Assert.assertTrue(this.ln_errorText.isDisplayed());
		  if (this.ln_errorText.isDisplayed()) {
			  System.out.println("Pass");
		  } else { 
			  System.out.println("PasswordChanged"); 
		  }
	}

}
