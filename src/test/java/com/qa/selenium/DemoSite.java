package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.pom.demo.DemoHomePage;

public class DemoSite {

    private static RemoteWebDriver driver;
    private static Logger LOGGER = Logger.getGlobal();

    @BeforeClass
    public static void initialise(){
        LOGGER.setLevel(Level.ALL);
        System.setProperty(
        		"webdriver.chrome.driver",
        		"src/test/resources/drivers/chromedriver.exe");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        // timeouts
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void createUser(){
    	String userCred = "root";
    	
        LOGGER.warning("Connecting to The Demo Site....");

        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get("http://thedemosite.co.uk/");
        	
        	DemoHomePage website = PageFactory.initElements(driver, DemoHomePage.class);

        // STAGE 2 - create a user.
        // ========================================
            LOGGER.info("Creating a new user...\n");
            website.navAddUser();
            website.addUserPage.adduser("root", "root");
                        
            //Navigate to login
            website.navloginPage();

        // STAGE 3 - Log in as created user.
        // ========================================
            LOGGER.info("Logging in as created user...\n");
            
            website.loginPage.loginUser("root", "root");
            
            String status = website.loginPage.getStatus();
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");

            // Assert success
            assertEquals("**Successful Login**", status);
    }


    @After
    public void tearDown() {
        LOGGER.warning("Closing webdriver instance!");

        driver.close();

        LOGGER.info("!!! Webdriver closed successfully !!!");
    }
}