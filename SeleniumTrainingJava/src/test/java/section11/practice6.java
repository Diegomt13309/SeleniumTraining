package section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practice6 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String aux=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        Select newSelect=new Select(dropdown);
        newSelect.selectByVisibleText(aux);
        driver.findElement(By.name("enter-name")).sendKeys(aux);
        driver.findElement(By.id("alertbtn")).click();
        String text=  driver.switchTo().alert().getText();
        if(text.contains(aux)){
            System.out.println("Alert message success");
        }
        else {
            System.out.println("Something wrong with execution");
        }
    }
}