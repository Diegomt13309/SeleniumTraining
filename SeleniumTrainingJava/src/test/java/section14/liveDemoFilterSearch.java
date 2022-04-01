package section14;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class liveDemoFilterSearch {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Enter de text on the box
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> values = driver.findElements(By.cssSelector(".table.table-bordered tbody tr td:first-child"));
        List<WebElement> veggies = values.stream().filter(veg -> veg.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(values.size(), veggies.size());
    }
}