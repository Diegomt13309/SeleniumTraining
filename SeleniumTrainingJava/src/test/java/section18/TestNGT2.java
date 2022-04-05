package section18;

import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGT2 {

    @Test(groups = {"Smoke"})
    public void demo3(){
        System.out.println("Hello TestNG3!");
    }

    @Test
    public void demo4(){
        System.out.println("Hello TestNG4!");
    }

    @BeforeTest
    public void clean(){
        System.out.println("Execute before the test");
    }
}