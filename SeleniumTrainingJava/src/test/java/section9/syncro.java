package section9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class syncro {

    public static void main(String[] arg){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        String[] names = {"Cucumber","Brocolli","Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        addItems(driver,names);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
        //explicit
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        //Explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        String text = driver.findElement(By.className("promoInfo")).getText();
        Assert.assertEquals(text,"Code applied ..!");
    }
    public static void addItems(WebDriver driver, String[] names){
        List<WebElement> list =  driver.findElements(By.cssSelector("h4.product-name"));

        int j = 0;
        for(int i = 0; i<list.size(); i++){
            String[] name = list.get(i).getText().split("-");
            String item = name[0].trim();
            List<String> items = Arrays.asList(names);
            if(items.contains(item)){
                j++;
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                if(j==names.length){
                    break;
                }
            }
        }
    }
}