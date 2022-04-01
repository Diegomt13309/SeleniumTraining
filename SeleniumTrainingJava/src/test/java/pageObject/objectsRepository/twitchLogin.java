package pageObject.objectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class twitchLogin {
    WebDriver driver;

    public void setUp(WebDriver driver){
        this.driver = driver;
    }
    //username field
    By username = By.id("login-username");
    public WebElement emailField(){
        return driver.findElement(username);
    }
    //password field
    By password = By.id("password-input");
    public WebElement passwordField(){
        return driver.findElement(password);
    }
    //login button
    By loginButton = By.cssSelector("button[data-a-target='passport-login-button']");
    public WebElement loginButton(){
        return driver.findElement(loginButton);
    }
    //failMessage
    By message = By.cssSelector("div[class$='Layout-sc-nxg1ff-0 gPDDcl'] > strong");
    public WebElement message(){
        return driver.findElement(message);
    }
}