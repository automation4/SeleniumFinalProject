package com.tests.PracticeTests.Practice;

import com.tests.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SetPropertyApproachTest {

    private WebDriver driver;

    @Test(priority = 0)
    public void OpenBrowser(){
     System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/java/com/tests/SeleniumBase1/DriverFiles/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Constant.ASKOMDCH_URL);
    }

    @Test(priority = 1)
    public void CloseBrowser(){
        driver.quit();
    }
}
