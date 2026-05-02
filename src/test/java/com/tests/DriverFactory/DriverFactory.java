package com.tests.DriverFactory;

import com.tests.BrowsersEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private ThreadLocal<WebDriver> threaddriver = new ThreadLocal<>();
    private String browser;

    public DriverFactory(String browser) { //cont
        this.browser = browser.toUpperCase();
    }

        public WebDriver createThreadSafeDriver(){
        switch(BrowsersEnum.valueOf(browser))
        {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-save-password-bubble");
                threaddriver.set(new ChromeDriver(chromeOptions));
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                firefoxOptions.addPreference("permissions.default.desktop-notification", 2);
                threaddriver.set(new FirefoxDriver(firefoxOptions));
                break;
            default:
                throw new IllegalStateException("Do not know how to start " + browser);
        }
        return threaddriver.get();
    }

}
