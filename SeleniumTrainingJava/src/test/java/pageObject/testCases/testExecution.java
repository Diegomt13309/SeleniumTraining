package pageObject.testCases;


import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.objectsRepository.twitchHomePage;
import pageObject.objectsRepository.twitchLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class testExecution {

    final twitchLogin loginPage = new twitchLogin();
    final twitchHomePage homePage = new twitchHomePage();
    public static WebDriver driver;
    public static final Assertion assertion = new Assertion();
    public static final String[] expectedTitles = {"This username does not exist.","That password was incorrect. Please try again."};


    @BeforeMethod
    public static void setupAll(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.twitch.tv/");
    }

    @Test
    public void login() throws InterruptedException {
        loginPage.setUp(driver);
        homePage.setUp(driver);
        List<String> expectedTitlesList = Arrays.asList(expectedTitles);

        homePage.loginButton().click();


        loginPage.emailField().sendKeys("diego98234");

        loginPage.passwordField().sendKeys("123");

        loginPage.loginButton().click();

        String message = loginPage.message().getText();
        assertion.assertTrue(expectedTitlesList.contains(message));
    }


    @AfterMethod
    public void close(){
        driver.close();
        System.out.println("Terminamos las pruebas");
    }

}