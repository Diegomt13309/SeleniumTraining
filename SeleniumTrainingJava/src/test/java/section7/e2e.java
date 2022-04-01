package section7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class e2e {
    public static void main(String[] arg) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        //Checkboxes
        boolean selected = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
        Assert.assertFalse(selected);
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        selected = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
        Assert.assertTrue(selected);

        String opa = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(opa);
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        opa = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(opa);
        if(opa.contains("opacity: 0.5")){
            Assert.fail("The current one is enabled");
        }else{
            Assert.assertTrue(true);
        }
        //all checkboxes
        int size = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        Assert.assertEquals(size,6);
        //dropdown with select tag CURRENCY DROPDOWN
        WebElement currency = driver.findElement(By.id("divpaxinfo"));
        currency.click();
        Thread.sleep(1000);
        WebElement add = driver.findElement(By.id("hrefIncAdt"));
        /*
        int i = 1;
        while(i<5){
            add.click();
            i++;
        }
        */
        for(int i=1; i<5; i++){
            add.click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(currency.getText(), "5 Adult");
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        WebElement buttonSearch = driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights"));
        buttonSearch.click();
    }
}