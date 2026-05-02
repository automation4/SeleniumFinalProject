package com.tests.PageObjects;

import com.tests.Base.BasePage;
import com.tests.Constant;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    private String pageurl = Constant.HEROKUAPP_URL;
    private By login = By.xpath("//a[@href='/login']");

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    public WelcomePage OpenWelcomePage(){
        log.info("Opening Page " + pageurl);
        driver.get(pageurl);
        log.info("Welcome page opened");
        return this;
    }

    public LoginPage goToLoginPage(){
       driver.findElement(login).click();
        log.info("Going to Login Page");
        return new LoginPage(driver, log);
    }

}
