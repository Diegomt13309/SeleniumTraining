package section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class practice2 {

    public static void main(String[] arg){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //Name
        driver.findElement(By.name("name")).sendKeys("Diego");
        //Email
        driver.findElement(By.name("email")).sendKeys("Diego@test.com");
        //Password
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("123Password");
        //Check ice cream
        driver.findElement(By.id("exampleCheck1")).click();
        //Gender
        WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(genderDropdown);
        dropdown.selectByIndex(0);
        //Employment
        driver.findElement(By.id("inlineRadio1")).click();
        //birthday
        driver.findElement(By.name("bday")).sendKeys("08/08/1876");
        //submit
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        //Submission Text
        String text = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        System.out.println(text);
    }
}