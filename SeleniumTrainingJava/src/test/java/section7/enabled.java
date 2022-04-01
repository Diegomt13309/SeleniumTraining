package section7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class enabled {
    public static void main(String[] arg) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //Checkboxes
        boolean selected = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
        Assert.assertFalse(selected);
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        selected = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
        Assert.assertTrue(selected);

        String opa = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(opa);
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        opa = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(opa);
        if(opa.contains("opacity: 1")){
            System.out.println("Is enabled");
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
        //all checkboxes
        int size = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        Assert.assertEquals(size,6);
        //dropdown with select tag CURRENCY DROPDOWN
        WebElement currency = driver.findElement(By.id("divpaxinfo"));
        currency.click();
        Thread.sleep(1000);
        WebElement add = driver.findElement(By.id("hrefIncAdt"));
        /*
        int i = 1;
        while(i<5){
            add.click();
            i++;
        }
        */
        for(int i=1; i<5; i++){
            add.click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(currency.getText(), "5 Adult");
    }
}