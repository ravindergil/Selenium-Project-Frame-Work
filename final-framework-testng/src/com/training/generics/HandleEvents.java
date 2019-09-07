package com.training.generics;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.training.sanity.tests.AddProductTest;

public class HandleEvents implements WebDriverEventListener {
	
	public static final Logger logger = LogManager.getLogger(AddProductTest.class.getName());

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		logger.info("Before Alert Accept");
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		logger.info("After Alert Accept");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		logger.info("After Alert Dismiss");
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		logger.info("Before Alert Dismiss");
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("Navigating to : " + url);
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("Navigated to : " + url);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		logger.info("Navigating Back");
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		logger.info("Navigated Back");
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		logger.info("Refreshing the page");
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		logger.info("Refreshed the page");
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Finding Element using : " + by + " = " + element);
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Element located using : " + by + " = " + element);
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicking on Element : " + element);
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicked on Element : " + element);
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

}
