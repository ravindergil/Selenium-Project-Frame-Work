package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePasswordPOM;

public class ChangePasswordTest extends LoginTests{
	
	private ChangePasswordPOM ChangePass;
	private ScreenShot screenShot;
	
	@Test(dependsOnMethods="validLoginTest")
	public void validateChangePassword(){
		ChangePass = new ChangePasswordPOM(driver);
		ChangePass.fn_clickChangePassword();
		ChangePass.fn_enterPassword("mehandi");
		ChangePass.fn_enterConfirmPassword("manzoor");
		ChangePass.fn_clickContinue();
		ChangePass.fn_checkErrorText();
		
		
	}

}
