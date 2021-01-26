package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.webpages.demosite.DemoSiteHomePage;

public class DemoSite {

	private static WebDriver driver;
	private static WebElement targ;
	private static Logger LOGGER = Logger.getGlobal();

	@BeforeClass
	public static void initialise() {

		LOGGER.setLevel(Level.ALL);

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// timeouts
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void createUser() {
		// STAGE 1 - GIVEN I can navigate to site.
        // ========================================
		LOGGER.warning("Connecting to The Demo Site....");
		DemoSiteHomePage website = PageFactory.initElements(driver, DemoSiteHomePage.class);

        // STAGE 2 - WHEN I create a user.
        // ========================================
		LOGGER.info("Creating a new user...\n");
		website.navAddUser();
		website.addUsers_Page.signUp("root", "root");

        // STAGE 3 - AND I Log in as created user.
        // ========================================
		LOGGER.info("Logging in as created user...\n");
		website.navLogin();
		website.login_Page.login("root", "root");

        // STAGE 4 - THEN check I've successfully logged in.
        // ========================================
		LOGGER.info("Checking success of automated test...\n");
		String status = website.login_Page.getStatus();

		// Assert success
		assertEquals("**Successful Login**", status);
	}

	@AfterClass
	public static void tearDown() {
		LOGGER.warning("Closing webdriver instance!");

		driver.quit();

		LOGGER.info("!!! Webdriver closed successfully !!!");
	}
}