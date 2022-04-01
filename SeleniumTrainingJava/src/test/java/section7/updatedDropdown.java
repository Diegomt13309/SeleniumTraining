package section7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class updatedDropdown {
    public static void main(String[] arg) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //dropdown with select tag CURRENCY DROPDOWN
        WebElement currency = driver.findElement(By.id("divpaxinfo"));
        currency.click();
        Thread.sleep(1000);
        WebElement add = driver.findElement(By.id("hrefIncAdt"));
        /*int i = 1;
        while(i<5){
            add.click();
            i++;
        }*/
        for(int i=1; i<5; i++){
            add.click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String texto = currency.getText();
        System.out.println(texto);

    }
}