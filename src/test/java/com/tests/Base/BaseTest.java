package com.tests.Base;

import com.tests.DriverFactory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

protected WebDriver driver;
protected Logger log;
@Parameters({"browser"})
@BeforeTest(alwaysRun = true)
public void setUPDriver(@Optional("chrome")String browser, ITestContext context){
    String testName = context.getCurrentXmlTest().getName(); // is pulling the name of the <test> tag from your TestNG XML file (testng.xml).
    log = LogManager.getLogger(testName); //current test
   DriverFactory factory = new DriverFactory(browser);
    driver = factory.createThreadSafeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    context.setAttribute("driver", driver); // store in context

}

@AfterTest(alwaysRun = true)
public void tearDown(){
    log.info("Closing Driver");
    driver.quit();
}

}
