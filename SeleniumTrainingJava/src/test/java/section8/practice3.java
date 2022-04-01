package section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class practice3 {

    public static void main(String[] arg){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        String[] phones = {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        login(driver,wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='my-4']")));
        addItems(driver,phones);
        WebElement checkout = driver.findElement(By.cssSelector(".nav-link.btn.btn-primary"));
        checkout.click();
        String fullPrice = driver.findElement(By.cssSelector("td>h3>strong")).getText();
        Assert.assertEquals(fullPrice, "₹. 300000");
    }
    public static void addItems(WebDriver driver, String[] phones){
        List<WebElement> list =  driver.findElements(By.cssSelector("h4.card-title > a"));
        int j = 0;
        for(int i = 0; i<list.size(); i++){
            String item = list.get(i).getText();
            List<String> items = Arrays.asList(phones);
            if(items.contains(item)){
                j++;
                driver.findElements(By.cssSelector("button[class$='btn btn-info']")).get(i).click();
                if(j==phones.length){
                    break;
                }
            }
        }
    }

    public static void login(WebDriver driver, WebDriverWait wait){
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement dropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }
}