package section7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class staticDropdown {
    public static void main(String[] arg) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //dropdown with select tag CURRENCY DROPDOWN
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        String text = dropdown.getFirstSelectedOption().getText();
        System.out.println(text);
        dropdown.selectByVisibleText("AED");
        text = dropdown.getFirstSelectedOption().getText();
        System.out.println(text);
        dropdown.selectByValue("INR");
        text = dropdown.getFirstSelectedOption().getText();
        System.out.println(text);
    }
}