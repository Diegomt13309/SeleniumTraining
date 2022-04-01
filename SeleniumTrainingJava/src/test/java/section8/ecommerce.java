package section8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class ecommerce {

    public static void main(String[] arg){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        String[] names = {"Cucumber","Brocolli","Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> list =  driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for(int i = 0; i<list.size(); i++){
            String[] name = list.get(i).getText().split("-");
            String item = name[0].trim();
            List<String> items = Arrays.asList(names);
            if(items.contains(item)){
                j++;
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                if(j==names.length){
                    break;
                }
            }
        }

    }
}