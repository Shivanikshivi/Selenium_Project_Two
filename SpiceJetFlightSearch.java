package com.automation.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetFlightSearch {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        // One way trip search
        searchFlight(driver, "Thiruvananthapuram", "Chennai", "22/12/2023", false);

        // Round trip search
        searchFlight(driver, "Thiruvananthapuram", "Chennai", "22/12/2023", true);

        driver.quit();
    }

    public static void searchFlight(WebDriver driver, String origin, String destination, String departureDate, boolean isRoundTrip) {
        // Locate elements for one way or round trip radio button
        WebElement oneWayRadio = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/svg/g/circle[2]"));
        WebElement roundTripRadio = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/svg/g/circle[1]"));

        // Choose between one way and round trip
        if (isRoundTrip) {
            roundTripRadio.click();
        } else {
            oneWayRadio.click();
        }

        
        WebElement originInput = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div[1]/div[2]/input"));
        originInput.clear();
        originInput.sendKeys(origin);

        WebElement destinationInput = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div[1]/div[2]/input"));
        destinationInput.clear();
        destinationInput.sendKeys(destination);

        WebElement departureDateInput = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]/div[2]"));
        departureDateInput.clear();
        departureDateInput.sendKeys(departureDate);
        
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div"));
        searchButton.click();
        
        WebElement selectFlightButton = driver.findElement(By.xpath("<div class=\"css-76zvg2 r-homxoj r-1i10wst r-1kfrs79\" dir=\"auto\" style=\"font-family: inherit;\">19:55</div>")); 
        selectFlightButton.click();

      //booking page
        WebElement proceedToBookingButton = driver.findElement(By.xpath("//*[@id=\"travellers-view\"]/div[2]/div/div/div[2]")); 
        proceedToBookingButton.click();

//dummy information
        driver.get("https://www.spicejet.com/");
        
        WebElement titleInput = driver.findElement(By.xpath("//*[@id=\"primary-contact-details\"]/div[3]/div[1]/div[2]/div/div[2]"));
        titleInput.sendKeys("Ms");
        
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"primary-contact-details\"]/div[3]/div[2]/div/div/div[2]/input"));
        firstNameInput.sendKeys("K");

        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"primary-contact-details\"]/div[3]/div[3]/div/div/div[2]/input"));
        lastNameInput.sendKeys("Shivani");

       
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"primary-contact-details\"]/div[4]/div[1]/div/div/div[2]/input"));
        emailInput.sendKeys("shivanikshivi@gmail.com");     

       
        WebElement submitButton = driver.findElement(By.id("//*[@id=\"travellers-view\"]/div[2]/div/div/div[2]"));
        submitButton.click();
        
        //confirmation message
        driver.get("https://www.spicejet.com/");
        WebElement confirmationMessage = driver.findElement(By.xpath("//*[@id=\"confirmation-message\"]/div[2]/div/div[2]/div")); 
        if (confirmationMessage.isDisplayed()) {
            System.out.println("Booking successful! Confirmation message found: " + confirmationMessage.getText());
        } else {
            System.out.println("Booking not confirmed");
        }
//
        
    }
}