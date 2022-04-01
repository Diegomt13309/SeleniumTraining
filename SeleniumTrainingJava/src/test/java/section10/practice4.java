package section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class practice4 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> i = windows.iterator();
        String parentId = i.next();
        String childId = i.next();
        driver.switchTo().window(childId);
        String text = driver.findElement(By.cssSelector(".example > h3")).getText();
        System.out.println(text);
        driver.switchTo().window(parentId);
        text = driver.findElement(By.cssSelector(".example > h3")).getText();
        System.out.println(text);
    }
}