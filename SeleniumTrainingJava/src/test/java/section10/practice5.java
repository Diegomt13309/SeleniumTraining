package section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class practice5 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        WebElement frameParent = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(frameParent);
        WebElement frameMiddle = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(frameMiddle);
        System.out.println(driver.findElement(By.id("content")).getText());
    }
}