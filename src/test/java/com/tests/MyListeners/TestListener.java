package com.tests.MyListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tests.Base.BaseTest;
import com.tests.ExtentReports.ExtentManager;
import com.tests.Utilities.ScreenshotUtilManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener  implements ITestListener {
    private static ExtentReports extentReport = ExtentManager.getReport();
    private static ThreadLocal<ExtentTest> extentTestThread =new ThreadLocal<>();
    private static final Logger log = LogManager.getLogger(TestListener.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
      ExtentTest test = extentReport.createTest(iTestResult.getMethod().getMethodName());
        extentTestThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTestThread.get().log(Status.PASS,"Test Passed: " + MarkupHelper.createLabel("Success", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("in Fail block");
        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("driver");
        String testName = iTestResult.getMethod().getMethodName();
        extentTestThread.get().fail("Test Failed " + testName);
        extentTestThread.get().fail(iTestResult.getThrowable());
        String  screenshotPath = null;

        try {
            screenshotPath = ScreenshotUtilManager.captureScreenshot(driver,testName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTestThread.get().addScreenCaptureFromPath(screenshotPath);
        }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        extentTestThread.get().log(Status.SKIP, "Test Skipped: " + MarkupHelper.createLabel("Skipped",ExtentColor.BROWN));

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
      if(extentReport!=null){
          extentReport.flush();
      }
    }
}
