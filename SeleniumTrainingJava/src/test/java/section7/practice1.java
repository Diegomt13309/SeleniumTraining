package section7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class practice1 {
    public static void main(String[] arg) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Check de first checkbox
        WebElement checkBox1 = driver.findElement(By.id("checkBoxOption1"));
        checkBox1.click();
        //Verify if is checked
        Assert.assertTrue(checkBox1.isSelected());
        //click again
        checkBox1.click();
        //Verify if is unchecked
        Assert.assertFalse(checkBox1.isSelected());
        //count of checkboxes
        List<WebElement> boxes = driver.findElements(By.cssSelector("input[type*='checkbox']"));
        System.out.println(boxes.size());
    }
}