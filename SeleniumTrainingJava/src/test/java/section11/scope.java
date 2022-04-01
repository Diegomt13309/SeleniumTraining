package section11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class scope {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/#");

        //1: Count of links in the page
        int links = driver.findElements(By.tagName("a")).size();
        System.out.println("Links (a), in the page: "+ links);

        //2: Count of links in the footer
        //Method 1
        links = driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size();
        System.out.println("M(1) - Links (a), in the footer page: "+ links);
        //Method 2
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //limiting webdriver scope
        links = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("M(2) - Links (a), in the footer page: "+ links);

        //3: Count of links first column footer table[class$='gf-t'] td:first-child
        WebElement columDriver = footerDriver.findElement(By.cssSelector("table[class$='gf-t'] td:first-child ul"));
        links = columDriver.findElements(By.tagName("a")).size();
        System.out.println("Links (a), in the first column of the footer page: "+ links);

        //4: Click on each link of the column and check if they are working
        for(int i=1; i<links; i++){
            String clickOnLink = Keys.chord(Keys.COMMAND, Keys.ENTER); //Command Mac - Control Windows
            columDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
        }
    }
}