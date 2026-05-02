package com.tests.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class BasePage {

   protected WebDriverWait wait ;
   protected WebDriver driver;
   protected Logger log;


    public BasePage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

}
