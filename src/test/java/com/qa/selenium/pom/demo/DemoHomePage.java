package com.qa.selenium.pom.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoHomePage {
	
	public static final String URL = "http://thedemosite.co.uk/";
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement navUserPage;
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement navloginPage;
	
	public DemoAddUser addUserPage;
	public DemoLogin loginPage;
	
	public DemoHomePage(WebDriver driver) {
		this.addUserPage = PageFactory.initElements(driver, DemoAddUser.class);
		this.loginPage = PageFactory.initElements(driver,  DemoLogin.class);
	}
	
	public void navAddUser() {
		navUserPage.click();
	}	
	
	public void navloginPage() {
		navloginPage.click();
	}
	

}
