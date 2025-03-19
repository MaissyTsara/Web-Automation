package com.webautomation.locator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemo {
    public static void main(String[] args) {
         System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        //Skenario Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
        driver.findElement(By.className("submit-button")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_item")));

        //List Product
        List<WebElement> listItem = driver.findElements(By.cssSelector("div.inventory_item"));
        
        //Define item name
        String itemName1 = "Sauce Labs Backpack";
        String itemName2 = "Sauce Labs Bike Light";
        String itemName3 = "Sauce Labs Bolt T-Shirt";
        String itemName4 = "Sauce Labs Fleece Jacket";
        String itemName5 = "Sauce Labs Onesie";
        String itemName6 = "Test.allTheThings() T-Shirt (Red)";

        //Add item1
        WebElement item1 = listItem.stream().filter(item ->
        item.findElement(By.cssSelector("div.inventory_item_name")).getText().equals(itemName1)).findFirst().orElse(null);
        
        System.out.println("List Item : " + item1);
        System.out.println("Ini adalah list items : " + listItem);
        
        item1.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-backpack'])[1]")).click();
        System.out.println("Add item 1 : " + itemName1);

        //Add item2
        WebElement item2 = listItem.stream().filter(item ->
        item.findElement(By.cssSelector("div.inventory_item_name")).getText().equals(itemName2)).findFirst().orElse(null);
        item2.findElement(By.cssSelector(("#add-to-cart-sauce-labs-bike-light"))).click();
        System.out.println("Add item 2 : " + itemName2);

        //Add item3
        WebElement item3 = listItem.stream().filter(item ->
        item.findElement(By.cssSelector("div.inventory_item_name")).getText().equals(itemName3)).findFirst().orElse(null);
        item3.findElement(By.cssSelector(("#add-to-cart-sauce-labs-bolt-t-shirt"))).click();
        System.out.println("Add item 3 : " + itemName3);

        //Add item4
        WebElement item4 = listItem.stream().filter(item ->
        item.findElement(By.cssSelector("div.inventory_item_name")).getText().equals(itemName4)).findFirst().orElse(null);
        item4.findElement(By.cssSelector(("#add-to-cart-sauce-labs-fleece-jacket"))).click();
        System.out.println("Add item 4 : " + itemName4);

        //Add item5
        WebElement item5 = listItem.stream().filter(item ->
        item.findElement(By.cssSelector("div.inventory_item_name")).getText().equals(itemName5)).findFirst().orElse(null);
        item5.findElement(By.cssSelector(("#add-to-cart-sauce-labs-onesie"))).click();
        System.out.println("Add item 5 : " + itemName5);

        //Add item6
        WebElement item6 = listItem.stream().filter(item ->
        item.findElement(By.cssSelector("div.inventory_item_name")).getText().equals(itemName6)).findFirst().orElse(null);
        item6.findElement(By.cssSelector(("button[id='add-to-cart-test.allthethings()-t-shirt-(red)']"))).click();
        System.out.println("Add item 6 : " + itemName6);

        //remove item5
        item5.findElement(By.cssSelector(("#remove-sauce-labs-onesie"))).click();
        System.out.println("Remove item 5 : " + itemName5);
        System.out.println(item5); //cetak id item5

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));

        //Klik shopping cart
        driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout")));

        //Remove item6
        driver.findElement(By.name("remove-test.allthethings()-t-shirt-(red)")).click();
        System.out.println("Remove item 6 : " + itemName6);

        //Checkout
        driver.findElement(By.cssSelector("#checkout")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#first-name")));

        //Input data diri
        driver.findElement(By.cssSelector("#first-name")).sendKeys("maissy");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("permatasari");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("50774");

        //Klik continue
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn_action")));

        //Klik Finish di review data page
        driver.findElement(By.className("btn_action")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));

        //Konfirmasi page

        // driver.findElement(By.className("complete-header")).getText("Thank you for your order!");

        String thanksOrder = driver.findElement(By.className("complete-header")).getText();

        System.out.println("Buyer berhasil checkout : " + thanksOrder);

        driver.quit();
    }
}
