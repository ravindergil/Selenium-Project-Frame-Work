package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminLogInPOM {
	
	private WebDriver driver;
	
	public AdminLogInPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement ln_userName;
	
	@FindBy(id="input-password")
	private WebElement ln_passWord;
	
	@FindBy(css="button.btn.btn-primary")
	private WebElement ln_clickLogIn;
	
	@FindBy(xpath="//div[@class='alert alert-danger'][contains(text(),' No match for Username and/or Password')]")
	private WebElement ErrorText;
	
	public void fn_senduserName(String userName) {
		this.ln_userName.clear();
		this.ln_userName.sendKeys(userName);
	}
	
	public void fn_sendpassWord(String passWord) {
		this.ln_passWord.clear();
		this.ln_passWord.sendKeys(passWord);
	}
	
	public void fn_clickLogIn() {
		this.ln_clickLogIn.click();
	}
	
	public void fn_VerifyErrorMessage() {
		String Text = this.ErrorText.getText().trim();
		String []arr = Text.split("\n");
		String ActualText = arr[0];
		String ExpectedText = "No match for Username and/or Password.";
		//System.out.println(ExpectedText);
		Assert.assertEquals(ActualText, ExpectedText);
	}
	

}
