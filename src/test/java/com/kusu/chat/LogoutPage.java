package com.kusu.chat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(tagName = "a")
	private WebElement loginLink;
	
	private WebDriver driver;
	
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void goToLogin() {
		loginLink.click();
	}
	
}
