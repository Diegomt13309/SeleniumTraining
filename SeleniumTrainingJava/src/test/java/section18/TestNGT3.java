package section18;

import org.testng.annotations.*;

public class TestNGT3 {

    @BeforeClass
    public  void befClass(){
        System.out.println("---Before class---");
    }


    @Parameters({"URL","APIKey/usrname"})
    @Test(groups = {"Smoke"})
    public void webLoginCarLoan(String url, String key){
        //selenium
        System.out.println("Web Login Car Loan: "+ url);
        System.out.println("Web Login Car Loan Key: "+ key);
    }

    @Test(timeOut = 4000,groups = {"Smoke"},dataProvider = "getData")
    public void mobileLoginCarLoan(String user, String pass){
        //appium
        System.out.println("Mobile Login Car Loan");
        System.out.println("Username: "+user+" & "+" Password: "+pass);
    }

    @Test(enabled = false)
    public void mobileLoginCarLoan2(){
        //appium
        System.out.println("Mobile Login Car Loan2");
    }

    @Test(dependsOnMethods = {"mobileLoginCarLoan"})
    public void APILoginCarLoan(){
        //Rest API automation
        System.out.println("API Login Loan");
    }

    @BeforeMethod
    public void befMet(){
        System.out.println("---Method---");
    }

    @AfterMethod
    public void aftMet(){
        System.out.println("--After Method--");
    }

    @DataProvider
    public Object[][] getData(){
        //[] how many times will be executed, [] how many parameters will get the execution
        Object[][] data = new Object[3][2];
        data[0][0]="FirstUsername";
        data[0][1]="FirstPassword";

        data[1][0]="SecondUsername";
        data[1][1]="SecondPassword";

        data[2][0]="ThirdUsername";
        data[2][1]="ThirdPassword";

        return data;
    }

}