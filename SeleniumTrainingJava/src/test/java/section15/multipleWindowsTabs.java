package section15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class multipleWindowsTabs {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> i = windows.iterator();
        String parentW = i.next();
        String childW = i.next();
        driver.switchTo().window(childW);
        driver.get("https://rahulshettyacademy.com/#/index");
        Actions actions = new Actions(driver);
        WebElement course = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1);
        actions.moveToElement(course);
        actions.perform();
        String name = course.getText();
        driver.switchTo().window(parentW);
        WebElement fieldName = driver.findElement(By.name("name"));
        fieldName.sendKeys(name);
        //screenshot of the Web Element
        File file = fieldName.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("name.png"));
        //Height and width
        int h = fieldName.getRect().getDimension().getHeight();
        int w = fieldName.getRect().getDimension().getWidth();
        System.out.println("H: "+h+", "+"W: "+w);
        driver.quit();



    }

}