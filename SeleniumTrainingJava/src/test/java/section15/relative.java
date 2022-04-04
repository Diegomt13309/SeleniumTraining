package section15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class relative {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditbox = driver.findElement(By.cssSelector("[name='name']"));

        String textLabel = driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText();
        System.out.println("Using Relative-> "+textLabel);

        WebElement birth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(birth)).click();

        WebElement iceCream = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();

        iceCream = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();

        WebElement rbutton = driver.findElement(By.id("inlineRadio1"));
        String radioText = driver.findElement(with(By.tagName("label")).toRightOf(rbutton)).getText();
        System.out.println(radioText);

        driver.close();
    }
}