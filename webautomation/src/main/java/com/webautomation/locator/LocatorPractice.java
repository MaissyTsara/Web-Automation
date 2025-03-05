package com.webautomation.locator;

import java.time.Duration;
<<<<<<< HEAD
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
=======

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
>>>>>>> f34e24e6bd4fd3ca8f92a815640937136da626ec

public class LocatorPractice {

    public static void main(String[] args) throws InterruptedException {
        
        //Setting chrome drivernya
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

<<<<<<< HEAD
        //untuk mencari locator, mencari posisi element itu di dalam suatu web
=======
>>>>>>> f34e24e6bd4fd3ca8f92a815640937136da626ec
        WebDriver driver = new ChromeDriver();
        //akses webnya
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(1000);       
        
<<<<<<< HEAD
        /*
         * Select currency
         * condition : dropdown
         * yg tipe datanya select option
         * kalau div tidak bisa diimplementasikan menggunakan cara berikut
         */

        /*
         * Bukan set constanta, tp tipe data, contoh : 
         * String x;
         * int y;
         * 
         * kalau tidak ada tipe data, tp cuman define something, contoh :
         * var S = 21;
         */

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        
        Select dropdown = new Select(staticDropdown);
        System.out.println("All option" + dropdown.getAllSelectedOptions().size());
        System.out.println("First option" + dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("USD");
        System.out.println("USD" + dropdown.getFirstSelectedOption().getText());
        Thread.sleep(1000); 

        dropdown.selectByValue("AED");
        Thread.sleep(1000); 

        dropdown.selectByIndex(1);
        Thread.sleep(1000); 

        /*
         * handle dynamic dropdown
         * karena kita tidak bisa langsung selected by value/by index meskipun sama2 dropdown
         * tp perlu melakukan adjustment karena implementasinya menggunakan div
         */

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);

        /*
         * Menambahkan passenger
         */
        for (int i=0; i<5; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Thread.sleep(1000);

        //child
        for(int i=0; i<3; i++){
            driver.findElement(By.id("hrefIncChd")).click();
        }
        Thread.sleep(1000);

        //decreased adult
        for(int i=0; i<3; i++){
            driver.findElement(By.id("hrefDecAdt")).click();
        }
        Thread.sleep(1000);

        //klik done button
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(1000);    

        /*
         * Scenario select From
         * Delhi = //div[@id="dropdownGroup1"]//child::div[@class="dropDownDiv"]//child::ul[1]//child::li//child::a[@value="DEL"]
         * //div[@id='dropdownGroup1']//div[@class='dropdownDiv']//child::ul[1]//child::li//child::a[@value="DEL"]
         */
        
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        Thread.sleep(1500);  

        // driver.findElement(By.xpath("//div[@id='dropdownGroup1']//child::div[@class='dropdownDiv']//child::ul[1]//child::li//child::a[@value='Bengalure']")).click();
        // driver.findElement(By.xpath("//div[@id='dropdownGroup1']//div[@class='dropdownDiv']//child::ul[1]//child::li//child::a[@value='DEL']")).click();
        // Thread.sleep(3000);    

        List<WebElement> optionList =  driver.findElements(By.xpath("//div[@id='dropdownGroup1']//div[@class='dropdownDiv']//child::ul[1]//child::li"));
        System.out.println("Ini adalah list opsinya : " + optionList);
        Thread.sleep(1000);

        //menggunakan for looping agar lebih dinamis dan tanpa mengubah xpath value nya
        for (WebElement element : optionList){
            System.out.println("List country " + element.getText());
            if (element.getText().equals("Belagavi (IXG)")){
                element.click();
                break;
            }
        }
        Thread.sleep(1000);

        driver.quit();
=======
        driver.close();
>>>>>>> f34e24e6bd4fd3ca8f92a815640937136da626ec
        
    }

}
