package section18;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGT4 {

    @Test
    public void webLoginHomeLoan(){
        //selenium
        System.out.println("Web Login Home Loan");
    }

    @Test
    public void mobileLoginHomeLoan(){
        //appium
        System.out.println("Mobile Login Home Loan");
    }

    @Test(groups = {"Smoke"})
    public void APILoginHomeLoan(){
        //Rest API automation
        System.out.println("API Login Home Loan");
        Assert.fail();
    }


}