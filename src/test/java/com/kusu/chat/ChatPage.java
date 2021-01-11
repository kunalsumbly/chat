package com.kusu.chat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
	@FindBy(id="messageText")
	private WebElement messageText;
	
	@FindBy(id="messageType")
	private WebElement messageType;
	
	@FindBy(id="submit-button")
	private WebElement submit;
	
	@FindBy(id="logout-link")
	private WebElement logout;
	
	private WebDriver driver;
	
	
	public ChatPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void sendChat(String messageText, String messageType) {
		this.messageText.sendKeys(messageText);
		this.messageType.sendKeys(messageType);
		submit.click();
	}
	
	public void logout() {
		logout.click();
	}
	
	public String findFirstMessage() {
		return driver.findElement(By.cssSelector("#chat")).getText();
	}
}
