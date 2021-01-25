package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSite {

    private static WebDriver driver;
    private static WebElement targ;
    private static Logger LOGGER = Logger.getGlobal();

    @BeforeClass
    public static void initialise(){
    	
        LOGGER.setLevel(Level.ALL);
        
        System.setProperty(
        		"webdriver.chrome.driver",
        		"src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        
        // timeouts
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void createUser(){
        LOGGER.warning("Connecting to The Demo Site....");

        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get("http://thedemosite.co.uk/");
        	
        // STAGE 2 - create a user.
        // ========================================
            LOGGER.info("Creating a new user...\n");
            // Navigate to add user page
            targ = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
            targ.click();
            
            // Fill details out
        	targ.findElement(By.name("username"));
        	targ.sendKeys("root");
        	targ.findElement(By.name("password"));
        	targ.sendKeys("root");
        	
        	// Submit user
        	targ.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
        	targ.click();

        // STAGE 3 - Log in as created user.
        // ========================================
            LOGGER.info("Logging in as created user...\n");        	
            // Navigate to login
            targ = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
            targ.click();
            
        	targ.findElement(By.name("username"));
        	targ.sendKeys("root");
        	targ.findElement(By.name("password"));
        	targ.sendKeys("root");
        	
        	// Login user
        	targ.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
        	targ.click();
        	
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");
            
            targ.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));

            String status = targ.getText();
             
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