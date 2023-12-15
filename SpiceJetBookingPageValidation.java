package com.automation.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetBookingPageValidation {


    public static void main(String[] args) {
    	WebDriver driver = new ChromeDriver(); 
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("Spicejet");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
    
        
        
        driver.get("https://www.spicejet.com/");

        
        WebElement checkInLink = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[2]/div[2]")); 
        checkInLink.click(); 

        
        driver.navigate().back();
       
        WebElement flightStatusLink = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[3]/div[2]")); 
        flightStatusLink.click(); 
        
        driver.navigate().back();

      
        WebElement manageBookingLink = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[4]/div[2]")); 
        manageBookingLink.click(); 

       //close browser
        driver.quit();
    }
}
    

