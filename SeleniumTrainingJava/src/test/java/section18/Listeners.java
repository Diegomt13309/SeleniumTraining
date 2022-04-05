package section18;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


//ITestListeners which implements testng listeners.
public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On Test Failure");
        System.out.println(result.id()+" "+result.getName()+" "+result.getStatus());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On Suite Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finishing the suite");
        System.out.println(context.getEndDate());
    }
}