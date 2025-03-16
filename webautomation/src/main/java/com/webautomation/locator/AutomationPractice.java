package com.webautomation.locator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPractice {
    public static void main(String[] args) throws InterruptedException {
        //Setting chrome drivernya
        System.setProperty("webdriver.chrome.driver", "D:/QA/COURSE/Learn After Office Bootcamp/Bootcamp Automation/Web Automation/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        Thread.sleep(1000); 
        
        //>>> 1. Radio Button Example
        driver.findElement(By.xpath("(//input[@value='radio1'])")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@value='radio2'])")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@value='radio3'])")).click();
        Thread.sleep(1000);

        //>>> 2. Suggession Class Example
        driver.findElement(By.xpath("(//input[@class='inputs ui-autocomplete-input'])")).sendKeys("ja");
        Thread.sleep(1000);

        List<WebElement> suggession =  driver.findElements(By.xpath("(//ul[@id='ui-id-1'])//child::li"));
        System.out.println("Ini adalah list opsi drop down suggession : " + suggession);
        Thread.sleep(1000);

        for (WebElement element : suggession){
            System.out.println("List country " + element.getText());
            if (element.getText().equals("Japan")){
                element.click();
                break;
            }
        }
        Thread.sleep(1000);

        //>>> 3. Dropdown Example
        driver.findElement(By.xpath("(//select[@id='dropdown-class-example'])")).click();
        Thread.sleep(1000);

        List<WebElement> dropdown =  driver.findElements(By.xpath("(//select[@id='dropdown-class-example'])//child::option"));
        System.out.println("Ini adalah list opsi drop down : " + dropdown);
        Thread.sleep(1000);     

        for (WebElement element : dropdown){
            System.out.println("List country " + element.getText());
            if (element.getText().equals("Option2")){
                element.click();
                break;
            }
        }
        Thread.sleep(2000);

        //>>> 4. Checkbox Example
        driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@id='checkBoxOption2'])")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@id='checkBoxOption3'])")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@id='checkBoxOption2'])")).click();
        Thread.sleep(2000);

        //>>> 5. Switch Window Example
        driver.findElement(By.id("openwindow")).click();
        Thread.sleep(2000);
        
        //menyimpan window handles
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String mainWindow = iterator.next();
        String newWindow = iterator.next();
        
        //pindah ke window baru
        driver.switchTo().window(newWindow);
        Thread.sleep(2000);
        
        //print judul halaman baru
        System.out.println("Judul halaman di window baru: " + driver.getTitle());
        
        //tutup window baru
        driver.close();
        
        //kembali ke window utama
        driver.switchTo().window(mainWindow);
        Thread.sleep(1000);

        //>>> 6. Switch Tab Example
        driver.findElement(By.id("opentab")).click();
        Thread.sleep(1000);

        Set<String> switchTab = driver.getWindowHandles();
        System.out.println("Ini adalah ID tab : " + switchTab);

        Iterator<String> iterator2 = switchTab.iterator();
        String mainTab = iterator2.next();
        String newTab = iterator2.next();

        Thread.sleep(1000);

        driver.switchTo().window(newTab);
        Thread.sleep(1000);

        driver.switchTo().window(mainTab);
        Thread.sleep(1000);

        //>>> 7. Switch To Alert Example
        driver.findElement(By.id("name")).sendKeys("input alert");
        Thread.sleep(1000);

        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //>>> 8. Web Table Example
        WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));

        List<WebElement> listTable =  table.findElements(By.tagName("tr"));
        System.out.println("Ini adalah list data dari Web Table : " + listTable.size());
        Thread.sleep(1000);

        // Loop untuk setiap baris dalam tabel
        for (WebElement elementTable : listTable) {
        // Ambil semua sel (td) di setiap baris
            List<WebElement> row = elementTable.findElements(By.tagName("td"));

            // Periksa apakah baris memiliki data (bukan header)
            if (!row.isEmpty()) {
                // Iterasi untuk setiap sel di baris
                for (WebElement cell : row) {
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println();
            }
        }
        Thread.sleep(2000);        

        //>>> 9.Element Displayed Example
        driver.findElement(By.xpath("(//input[@id='displayed-text'])")).sendKeys("input to show");
        Thread.sleep(1000);
        driver.findElement(By.id("hide-textbox")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("show-textbox")).click();
        Thread.sleep(1000);

        //>>> 10. Web Table Fixed header
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement webTableFixed = driver.findElement(By.xpath("//div[@class='tableFixHead']"));
        js.executeScript("arguments[0].scrollIntoView();", webTableFixed);
        Thread.sleep(2000);

        List<WebElement> elementTableFixed = webTableFixed.findElements(By.tagName("tr"));
        System.out.println("List Data dari Web Table Fixed : " + elementTableFixed.size());
        Thread.sleep(1000);

        for (WebElement fixedRow : elementTableFixed){
            List<WebElement> cells = fixedRow.findElements(By.tagName("td"));

            if (!cells.isEmpty()){
                for (WebElement cell : cells){
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println();
            }
        }
        Thread.sleep(1000);    

        Number lastHeight = (Number) js.executeScript("return arguments[0].scrollTop;", webTableFixed);
        Number newHeight;
        
        do {
            js.executeScript("arguments[0].scrollTop += 200;", webTableFixed);
            Thread.sleep(500); // jeda untuk stabilitas
            newHeight = (Number) js.executeScript("return arguments[0].scrollTop;", webTableFixed);
        
            System.out.println("Last Height: " + lastHeight);
            System.out.println("New Height: " + newHeight);
        
            if (lastHeight.equals(newHeight)) {
                break; // Keluar dari loop jika tidak ada perubahan
            }
        
            lastHeight = newHeight;
        } while (true);
        Thread.sleep(1000);

        WebElement totalAmount = driver.findElement(By.xpath("(//div[@class='totalAmount'])"));
        System.out.println(totalAmount.getText());

        //>>> 11. Mouse Hover Example
        WebElement mouseHoverButton = driver.findElement(By.id("mousehover"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoverButton).perform();
        Thread.sleep(2000);

        // Klik opsi "Top" setelah hover
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        WebElement topOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Top')]")));
        // WebElement topOption = driver.findElement(By.xpath("//a[contains(text(),'Top')]"));
        topOption.click();
        System.out.println("Hover Top");
        Thread.sleep(2000);

        actions.moveToElement(mouseHoverButton).perform();
        Thread.sleep(2000);
        // Klik opsi "Reload" setelah hover
        // WebElement reloadOption = driver.findElement(By.xpath("//a[contains(text(),'Reload')]"));
        WebElement reloadOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Reload')]")));
        reloadOption.click();
        System.out.println("Hover Reload");
        Thread.sleep(2000);

        //>>> 12. iFrame Example

        WebElement iframeExample = driver.findElement(By.xpath("(//legend[normalize-space()='iFrame Example'])"));
        System.out.println(iframeExample.getText());        

        WebElement iframeElement = driver.findElement(By.id("courses-iframe"));
        driver.switchTo().frame(iframeElement);

        //Scroll di dalam iframe
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0, 500);"); //Scroll ke bawah 500px
        Thread.sleep(2000);

        //Scroll ke paling bawah
        js2.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

        //Scroll kembali ke atas
        js2.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        driver.quit();
    }
}
