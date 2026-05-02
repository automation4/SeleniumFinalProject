package com.tests.PageObjects;

import com.tests.Base.BasePage;
import com.tests.Constant;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {


    By username = By.id("username");
    By password = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//button[@class='radius']/i");
    By successCheck =  By.xpath("//div[@class = 'flash success']");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    public LoginPage enterUserAndPassword(String user, String pass) throws InterruptedException {
        log.info("Login Page opened");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        log.info("entered User and password");
      return this;
        }

    public LoginPage clickLogin() throws InterruptedException {
        driver.findElement(loginBtn).click();
        log.info("login button clicked");
return this;
    }

    public void verifyIfSuccess() throws InterruptedException {
        String toast = driver.findElement(successCheck).getText().replaceFirst("×","").trim();
        System.out.println(toast);
            if (toast.equalsIgnoreCase(Constant.SUCCESS_TOAST)) {
                System.out.println("User is successfully logged in");
                log.info("User is successfully logged in");
        }else{
                Assert.fail("Expected : "+ Constant.SUCCESS_TOAST + "\n" + "Actual : "+ toast);}

    }


    public void verifyIfSuccessAttempt2() throws InterruptedException {
        String toast = driver.findElement(successCheck).getText();
        String actual = toast.substring(0,toast.length()-1).trim();
        System.out.println(actual);
        if (actual.equalsIgnoreCase(Constant.SUCCESS_TOAST)) {
            System.out.println("User is successfully logged in");
            log.info("User is successfully logged in");
        }else{
            log.info("User is unable to log in");
            Assert.fail("Expected : "+ Constant.SUCCESS_TOAST + "\n" + "Actual : "+ actual);}

    }
}
