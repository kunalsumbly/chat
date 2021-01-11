package com.kusu.chat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(id="inputUsername")
	private WebElement username;
	
	@FindBy(id="submit-button")
	private WebElement submit;
	
	@FindBy(id="signup-link")
	private WebElement signUpLink;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginWithCredentials(String userName, String password) {
		clearInputs();
		username.sendKeys(userName);
		this.password.sendKeys(password);
		submit.click();
	}
	
	public void signUp() {
		signUpLink.click();
	}
	
	public void clearInputs() {
		password.clear();
		username.clear();
	}

}
