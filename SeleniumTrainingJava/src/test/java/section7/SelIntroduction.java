package section7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

    public static void main(String[] arg){

        //Invoking Browser
        //Chrome - ChromeDriver   -> Methods, close, same methods in both drivers
        //Firefox - FirefoxDriver -> Methods, close, same methods in both drivers, etc
        //Webdriver -> Interface
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //driver.close(); only the first windows from the url, not from the other links
        driver.quit(); //close every window and finish the webdriver execution









    }
}