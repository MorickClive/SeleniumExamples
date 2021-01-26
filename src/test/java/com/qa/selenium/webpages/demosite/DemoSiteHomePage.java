package com.qa.selenium.webpages.demosite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBys;

import com.qa.selenium.webpages.demosite.pages.DemoAddUsersPage;
import com.qa.selenium.webpages.demosite.pages.DemoLoginPage;

public class DemoSiteHomePage {
	
	private final String URL = "http://thedemosite.co.uk/";
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUserPage;
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginUserPage;
	
	@FindBys( {
		@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"),
		@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"),
		@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	})
	private List<WebElement> listSomething;
	
	public DemoAddUsersPage addUsers_Page;
	public DemoLoginPage login_Page;

	public DemoSiteHomePage(WebDriver driver) {
    	driver.get(URL);
    	
    	addUsers_Page = PageFactory.initElements(driver, DemoAddUsersPage.class);
    	login_Page = PageFactory.initElements(driver, DemoLoginPage.class);
	}
	
	public void navAddUser() {
		addUserPage.click();
	}
	
	public void navLogin() {
		loginUserPage.click();
	}	

}
