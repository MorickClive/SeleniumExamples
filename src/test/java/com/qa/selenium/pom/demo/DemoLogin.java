package com.qa.selenium.pom.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLogin {
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "FormsButton2")
	private WebElement submit;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement status;
	
	public DemoLogin() {}
	
	public void loginUser(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		
		this.submit.click();
	}
	
	public String getStatus() {
		return this.status.getText();
	}

}
