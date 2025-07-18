package reports;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.SeleniumUtils;

public class ExtentTestNGListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseClass) result.getInstance()).getDriver();
        String screenshotPath = SeleniumUtils.captureScreenshot(driver, result.getName());
        test.get().fail(result.getThrowable());
        test.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
