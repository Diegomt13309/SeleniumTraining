package pageObject.objectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class twitchHomePage {
    WebDriver driver;
    public void setUp(WebDriver driver){
        this.driver = driver;
    }
    //loginButton
    By loginButton = By.cssSelector("button[data-a-target='login-button']");
    public WebElement loginButton(){
        return driver.findElement(loginButton);
    }
    //searchTab
    By searchTab = By.id("tw-1dad7a8166900c7d429bb2f043fa9995");
    public WebElement searchID(){
        return driver.findElement(searchTab);
    }
}