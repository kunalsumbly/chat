package com.kusu.chat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatApplicationTests {
	 	
		@LocalServerPort
	    private Integer port;
	    
	 	private static WebDriver driver;
	    
	 	private LoginPage loginPage;
	    
	 	private SignupPage signupPage;
	    
	 	private ChatPage chatPage;
	 	
	 	private LogoutPage logoutPage;
	    
	    @BeforeAll
	 	public static void beforeAll() {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    }
	    
	    @AfterAll
	    public static void afterAll() {
	    	driver.quit();
	    }
	    
	    @BeforeEach
	    public void beforeEach() {
	    	driver.get("http://localhost:"+port+"/chat");
	    	loginPage = new LoginPage(driver);
	    	signupPage = new SignupPage(driver);
	    	chatPage = new ChatPage(driver);
	    	logoutPage = new LogoutPage(driver);
	    }
	    
	    @Test
	    public void testSignup() throws InterruptedException {
	    	String messageTxt = userSignUpAndPushChat("kusu", "I am the user", "Shout", true);
	    	assertEquals(messageTxt.toUpperCase(),"I am the user".toUpperCase());
	    	
	    }

		private String userSignUpAndPushChat(String user, String messageTxt, String messageType, boolean sendChat) throws InterruptedException {
			// 1. go to signup page
	    	loginPage.signUp();
	    	// 2. enter first name , lastname, username and password
	    	Thread.sleep(2000);
	    	signupPage.register(user, user, user, user);
	    	Thread.sleep(2000);
	    	signupPage.hitLogin();
	    	Thread.sleep(2000);
	    	loginPage.loginWithCredentials(user, user);
	    	Thread.sleep(2000);
	    	if (sendChat) {
	    		chatPage.sendChat(messageTxt, messageType);
	    	}
	    	Thread.sleep(2000);
			return chatPage.findFirstMessage();
		}
	    
		@Test
	    public void testMultiUserChats() throws InterruptedException {
	    	String messageTxt = userSignUpAndPushChat("kusu", "I am the user", "Shout", true);
	    	assertEquals(messageTxt.toUpperCase(),"I am the user".toUpperCase());
	    	chatPage.logout();
	    	Thread.sleep(2000);
	    	logoutPage.goToLogin();
	    	Thread.sleep(5000);
			messageTxt = userSignUpAndPushChat("susu", "Hustle", "Whisper", false);
			Thread.sleep(3000);
			assertEquals(messageTxt.toUpperCase(),"I am the user".toUpperCase());
			chatPage.logout();
			Thread.sleep(2000);
			logoutPage.goToLogin();
	    }

}
