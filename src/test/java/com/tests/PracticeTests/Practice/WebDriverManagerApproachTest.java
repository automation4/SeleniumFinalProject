package com.tests.PracticeTests.Practice;

import com.tests.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverManagerApproachTest {

    private WebDriver driver;

    @Test(priority = 0)
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Constant.ASKOMDCH_URL);
    }

    @Test(priority = 1)
    public void CloseBrowser(){
        driver.quit();
    }
}
