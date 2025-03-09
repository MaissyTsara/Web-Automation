package com.webautomation.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) throws InterruptedException {
        //Setting chrome drivernya
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        //untuk mencari locator, mencari posisi element itu di dalam suatu web
        WebDriver driver = new ChromeDriver();
        //akses webnya
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("name")).sendKeys("Maissy");
        Thread.sleep(1000);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(1000);

        //Alert
        System.out.println(driver.switchTo().alert().getText());
        // driver.switchTo().frame("Hello Maissy, share this practice page and share your knowledge");

        // Klik OK pada alert
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        driver.quit();
    }
}
