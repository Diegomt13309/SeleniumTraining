package section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class practiceActions {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid]
        Iterator<String> i = windows.iterator();
        String parentId = i.next();
        String childId = i.next();
        driver.switchTo().window(childId);
        String email = driver.findElement(By.cssSelector(".im-para.red > strong")).getText();
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}