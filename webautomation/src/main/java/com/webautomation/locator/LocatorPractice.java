package com.webautomation.locator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        System.out.println("Ini adalah list opsi drop down 1 : " + optionList);
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

        /*
         * Arrival City
         */

        // driver.findElement(By.xpath("//body[1]/form[1]/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[3]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        List<WebElement> optionList2 =  driver.findElements(By.xpath("(//div[@id='dropdownGroup1']//div[@class='dropdownDiv']//child::ul[1])[2]//child::li"));
        System.out.println("Ini adalah list opsi drop down 2 : " + optionList2);
        Thread.sleep(1000);

        //menggunakan for looping agar lebih dinamis dan tanpa mengubah xpath value nya
        for (WebElement element : optionList2){
            System.out.println("List country " + element.getText());
            if (element.getText().equals("Delhi (DEL)")){
                element.click();
                break;
            }
        }
        Thread.sleep(1000);

        //klik tanggal
        driver.findElement(By.xpath("(//a[normalize-space()='5'])[1]")).click();
        Thread.sleep(1000); 

        //search data by inputing "ind"
        driver.findElement(By.xpath("(//*[@id='autosuggest'])[1]")).sendKeys("ind");
        Thread.sleep(1000);
      

        //memilih data indonesia

            //cara 1
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));

        // WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Indonesia')]")));
        // countryOption.click();

            //cara 2
        // driver.findElement(By.xpath("//a[@id='ui-id-127']")).click();
        // driver.findElement(By.xpath("(//a[normalize-space()='Indonesia'])[1]")).click();
        // Thread.sleep(1000);

            //cara 3
        List<WebElement> country = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement webElement : country){
            System.out.println("Ini adalah list negara berdasarkan pencarian : " + webElement.getText());
            if (webElement.getText().equals("Indonesia")){
                webElement.click();
                break;
            }
        }
        Thread.sleep(1000); 
        
        //handle radio button
        // driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_rbtnl_Trip_0'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_rbtnl_Trip_1'])[1]")).click();
        Thread.sleep(1000);

        //handle checkbox
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Thread.sleep(1000);

        driver.close();

        
    }

}
