package section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class checkLinks {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> links = footer.findElements(By.tagName("a"));
        for (WebElement link : links) {
            HttpURLConnection con = (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
            con.connect();
            int resCode = con.getResponseCode();
            if(resCode > 400){
                System.out.println("Link: '"+link.getText()+"' is broken, code: "+resCode);
                Assert.fail();
            }
        }
    }
}