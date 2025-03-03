package com.webautomation.locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {
    public static void main(String[] args) throws InterruptedException {
        // loginScenario();
        // incorrectPasswordScenario();
        loginForgotPasswordScenario();
    }

    public static void loginScenario() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //akses webnya
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(1000);        

            //input field username
        //CSS Selector
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("maissy1");
        
        Thread.sleep(1000); 

            //input field password
        //XPath
        //driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
        //Name
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        //TagName
        // driver.findElement(By.tagName("input")).sendKeys("rahulshettyacademy");
        Thread.sleep(2000); 

            //klik button login
        driver.findElement(By.className("submit")).click();
        Thread.sleep(2000); 

            //Verifikasi berhasil login
        String successLogin = driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText();
        Thread.sleep(2000);
        System.out.println("Verifikasi berhasil login : " + successLogin);

        //klik button logout
        driver.findElement(By.className("logout-btn")).click();
        Thread.sleep(1000); 

        driver.quit();
    }

    public static void incorrectPasswordScenario() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //akses webnya
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(1000);        

            //input field username
        //ID
        driver.findElement(By.id("inputUsername")).sendKeys("maissy2");
        Thread.sleep(1000); 

            //input field password
        //XPath
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshetty");
        Thread.sleep(2000); 

            //klik button login
        driver.findElement(By.className("submit")).click();
        Thread.sleep(2000); 

            //Verifikasi gagal login
        String failedLogin = driver.findElement(By.cssSelector("p.error")).getText();
        Thread.sleep(2000);
        
        String userName = driver.findElement(By.id("inputUsername")).getText();
        String passWord = driver.findElement(By.tagName("input")).getText();
        
        System.out.println("Username : " + userName);
        System.out.println("Password : " + passWord);
        System.out.println("Verifikasi gagal login : " + failedLogin);    

        if (userName == "" || "".equals(passWord)){
            System.out.println("Credentialnya gagal");
        }

        // Assert.userName.equals("");

        driver.quit();
    } 

    public static void loginForgotPasswordScenario() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //akses webnya
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(1000);        

            //klik button forgot password
        driver.findElement(By.className("forgot-pwd-container")).click();
        Thread.sleep(1000); 

            //input username
        driver.findElement(By.tagName("input")).sendKeys("Maissy");
        Thread.sleep(1000); 

            //input email
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("maissy@gmail.com");
        Thread.sleep(1000); 

            //klik button reset login
        driver.findElement(By.xpath("//button[normalize-space()='Reset Login']")).click();
        Thread.sleep(2000); 

            //get info correct password
        String password = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        System.out.println(password);
        Thread.sleep(1000); 

            //Split untuk mendapatkan password
        String[] splitParts = password.split("'");
        String extractedPassword = splitParts[1];
    
        System.out.println("Password yang benar : " + extractedPassword);

            //klik button go to login
        driver.findElement(By.className("go-to-login-btn")).click();

            //input username
        driver.findElement(By.id("inputUsername")).sendKeys("maissy@gmail.com");
        Thread.sleep(1000);
            //input password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(extractedPassword);
        Thread.sleep(1000);
             
            //get username and password
        String uName = driver.findElement(By.cssSelector("#inputUsername")).getAttribute("value");
        String pass = driver.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("value");
        
            //debug data username dan password
        System.out.println("Username : " + uName);
        System.out.println("Password : " + pass);
        // System.out.println("Verifikasi gagal login : " + failedLogin);    

            //centang checkbox pertama
        driver.findElement(By.id("chkboxOne")).click();
            //centang checkbox kedua
        driver.findElement(By.cssSelector("#chkboxTwo")).click();
        Thread.sleep(2000);

            //klik button login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

            //Verifikasi berhasil login
        String successLogin = driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText();
        Thread.sleep(2000);
        System.out.println("Verifikasi berhasil login : " + successLogin);

            //klik button logout
        driver.findElement(By.className("logout-btn")).click();
        Thread.sleep(1000); 

        driver.quit();
    }

}
