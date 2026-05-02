package com.tests.PracticeTests.Practice;

import com.tests.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumManagerApproach_LatestTest {

    private WebDriver driver;

    @Test(priority = 0)
    public void OpenBrowser(){
        driver = new ChromeDriver();   // NO need of WebDriverManager or System.setProperty().. Since Selenium 4.6.0, Selenium Manager is built directly into the Selenium library
        driver.get(Constant.ASKOMDCH_URL);
    }

    @Test(priority = 1)
    public void CloseBrowser(){
        driver.quit();
    }
}
