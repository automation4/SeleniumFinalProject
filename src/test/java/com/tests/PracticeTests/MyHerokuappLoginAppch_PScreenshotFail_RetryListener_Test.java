package com.tests.PracticeTests;

import com.tests.Base.BaseTest;
import com.tests.MyListeners.RetryListener;
import com.tests.PageObjects.WelcomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyHerokuappLoginAppch_PScreenshotFail_RetryListener_Test extends BaseTest {


    @Parameters({"username","password"})
    @Test(retryAnalyzer = RetryListener.class) // 1 approach is to mention where you feel test case will fail
    public void LoginTest(String user, String pass) throws InterruptedException {

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.OpenWelcomePage().goToLoginPage().enterUserAndPassword(user,pass).clickLogin().verifyIfSuccessAttempt2();
    }


}
