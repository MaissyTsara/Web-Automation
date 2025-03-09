package com.webautomation.locator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {

    public static void main(String[] args) throws InterruptedException {
        
        //Setting chrome drivernya
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        //untuk mencari locator, mencari posisi element itu di dalam suatu web
        WebDriver driver = new ChromeDriver();
        //akses webnya
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(1000);       
        
        driver.close();
        
    }

}
