package section12;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class scrolling {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        List<WebElement> elements = driver.findElements(By.cssSelector(".tableFixHead > table td:nth-child(4)"));
        int sum = 0;
        for(int i = 0; i<elements.size(); i++){
            int ele = (Integer.parseInt(elements.get(i).getText()));
            System.out.println("Element #"+i+" : "+ele);
            sum+=ele;
        }
        System.out.println("--------------------");
        System.out.println("Total received: "+sum);
        String comp = driver.findElement(By.className("totalAmount")).getText();
        String[] aux = comp.split(":");
        Assert.assertEquals(Integer.parseInt(aux[1].trim()),sum);
    }
}