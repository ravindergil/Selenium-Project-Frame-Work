package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement ln_userName; 
	
	@FindBy(id="input-password")
	private WebElement ln_password;
	
	@FindBy(css="li[class='tb_link tb_menu_system_account_login']")
	private WebElement ln_logInRegister; 
	
	@FindBy(css="i[class='fa fa-user-o']")
	private WebElement ln_logInDropDown;
	
	@FindBy(css="input[class='btn btn-primary']")
	private WebElement ln_logIn; 
	
	public void fn_moveToLogin(){
		Actions act = new Actions(driver);
		act.moveToElement(this.ln_logInDropDown).build().perform();
	}
	
	public void sendUserName(String userName) {
		this.ln_userName.clear();
		this.ln_userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.ln_password.clear(); 
		this.ln_password.sendKeys(password); 
	}
	
	public void fn_clicklogInRegister() {
		this.ln_logInRegister.click(); 
	}
	
	public void clickLoginBtn() {
		this.ln_logIn.click(); 
	}
}
