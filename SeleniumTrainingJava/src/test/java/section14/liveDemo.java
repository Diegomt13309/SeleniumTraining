package section14;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class liveDemo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on the sorted button
        driver.findElement(By.cssSelector(".table.table-bordered th:first-child")).click();

        //grab the first colum of elements
        List<WebElement> values = driver.findElements(By.cssSelector(".table.table-bordered tbody tr td:first-child"));
        //get the names
        List<String> names = values.stream().map(WebElement::getText).collect(Collectors.toList());
        //sort the new list
        List<String> sortList = names.stream().sorted().collect(Collectors.toList());
        //compare two list
        Assert.assertEquals(sortList, names);

        //-------------

        //scan the names
        List<String> prices;
        do {
            values = driver.findElements(By.cssSelector(".table.table-bordered tbody tr td:first-child"));
            prices = values.stream().filter(s->s.getText().contains("Rice")).map(liveDemo::getPriceVeggie).collect(Collectors.toList());
            prices.forEach(System.out::println);
            if(prices.size()<1){
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        }while (prices.size()<1);

        driver.close();
    }

    private static String getPriceVeggie(@NotNull WebElement s){
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}