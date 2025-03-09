package com.webautomation.locator;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindow {
    public static void main(String[] args) throws InterruptedException {
        /*
         * Get id ttab/window
         * move ke tab lain menggunakan id tab tersebut
         * tab1 = 10
         * tab2 = 20
         * tab3 = 40
         * 
         * current_tab = 10
         * 
         * call tab2.id
         * call tab3.id
         */

        //Setting chrome drivernya
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        //untuk mencari locator, mencari posisi element itu di dalam suatu web
        WebDriver driver = new ChromeDriver();
        //akses webnya
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(1000);       
        
        
        driver.findElement(By.className("blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();

        /*
         * Akan menampilkan 2 value (parent, child)
         */
        System.out.println("Ini adalah windows : " + windows);

        // Menggunakan iterator untuk menyimpan value nya
        // Fungsi iterator untuk membedakan yg mana yg parent dan yg mana yg child
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();

        Thread.sleep(2000);

        driver.switchTo().window(childId);
        Thread.sleep(2000);

        driver.switchTo().window(parentId);
        Thread.sleep(2000);

        driver.switchTo().window(childId);
        Thread.sleep(2000);

        driver.switchTo().window(parentId);
        Thread.sleep(2000);

        driver.quit();
    }
}
