package com.webautomation.scenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        //belum implement testNG, fully running automationnya aja
        
        /*
         * 1. Implement e2e test for checkout
         * 2. wait !- Thread
         * 3. Stream
         */

        /*
         * Scenario Automation
         * 1. Buyer Login
         * 2. Buyer checkout product
         * 3. Verifikasi thanks page
         */

        //Setup driver
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));

        // Thread.sleep(10000); 

        //Seknario Login
        driver.findElement(By.id("userEmail")).sendKeys("maissypermata@gmail.com");
        // Thread.sleep(1000);
        driver.findElement(By.id("userPassword")).sendKeys("P@$$w0rd");
        // Thread.sleep(1000);

        driver.findElement(By.className("login-btn")).click();
        // Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        //1. Add to chart

        // >>> (//div[@class='row']//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted'])[1]
        // >>> tidak dinamis, posisinya bisa berubah, sehingga tidak disarankan by index, better by looping

        //List Product
        List<WebElement> listProduct = driver.findElements(By.cssSelector(".mb-3"));
        
        String productName = "ZARA COAT 3";

        WebElement product = listProduct.stream().filter(prod ->
        prod.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        
        System.out.println("List Product : " + product);

        System.out.println("Ini adalah list product : " + listProduct);

        product.findElement(By.xpath("//div[@class='card-body']//button[@class='btn w-10 rounded'][1]")).click();
        //pakai product bukan driver karena scope nya adalah hasil filter, bukan keseluruhan website nya seperti menggunakan driver
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        Thread.sleep(2000);
        // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//ngx-spinner[@class='ng-star-inserted']"))));

        driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
        // Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));

        driver.findElement(By.cssSelector(".totalRow button")).click();
        // Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Select Country']")));

        //>> Cara 1
        // driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
        
        //>> Cara 2
        Actions action = new Actions(driver);
        action.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "ind").build().perform();

        // Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-star-inserted']")));

        // List<Integer> numbers = Arrays.asList(1,2,3,4,5,5,5,5,55,5,5,5,5,5,6,7,8,9,10);
        // List<Integer> result = new ArrayList<>();
        
        // result = numbers.stream().filter(integer -> integer.equals(5)).collect(Collectors.toList());
        // System.out.println("Ini adalah result stream : " + result);

        String destination = "Indonesia";

        List<WebElement> country = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));

        System.out.println(country.get(2).getText());

        //Cara menggunakan for biasa
        // for (WebElement cont : country){
        //     if (cont.getText().equalsIgnoreCase(destination)){
        //         System.out.println(cont);
        //         cont.click();
        //     }
        //     else{
        //         System.out.println("None");
        //     }
        // }
        // Thread.sleep(2000);

        //Cara dengan menggunakan Stream
        WebElement cont = country.stream().filter(cont2 -> cont2.getText().equalsIgnoreCase(destination)).findFirst().orElse(null);
        cont.click();
        // Thread.sleep(2000);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));

        driver.findElement(By.cssSelector(".action__submit")).click();
        // Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hero-primary")));

        String confirmationPage = driver.findElement(By.className("hero-primary")).getText();
        System.out.println("Buyer berhasil checkout : " + confirmationPage);
        // Thread.sleep(2000);

        driver.quit();

        //Thread >> statis. Dia ngga peduli element nya sudah muncul atau belum. Jadi akan tetap menjalankan sampai detik ke 5. 
        //Wait >> dinamis. Akan berhenti ketika element yg kita cari sudah ada. Ketika sudah ketemu di detik ke 2, maka akan berhenti, tidak dijalankan sampai detik ke 5.

    }
}
