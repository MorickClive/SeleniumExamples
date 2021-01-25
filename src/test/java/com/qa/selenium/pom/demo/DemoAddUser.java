package com.qa.selenium.pom.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoAddUser {
	
	public static String URL = "http://thedemosite.co.uk/addauser.php";
	
	@FindBy(name = "username")
	private WebElement usernameInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submit;
	
	public DemoAddUser(WebDriver driver) {
				
	}
	
	public void adduser(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		submit.click();
	}

}
