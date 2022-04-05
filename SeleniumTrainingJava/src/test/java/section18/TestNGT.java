package section18;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGT {

    @AfterTest
    public void clean(){
        System.out.println("After Test");
    }

    @Test(groups = {"Smoke"})
    public void demo(){
        System.out.println("Hello TestNG!");
    }

    @Test
    public void demo2(){
        System.out.println("Hello TestNG2!");
    }

    @AfterSuite
    public void afSui(){
        System.out.println("---After suite---");
    }

}