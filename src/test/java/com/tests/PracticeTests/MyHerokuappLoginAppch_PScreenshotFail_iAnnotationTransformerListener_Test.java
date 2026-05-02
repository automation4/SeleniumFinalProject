package com.tests.PracticeTests;

import com.tests.Base.BaseTest;
import com.tests.PageObjects.WelcomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyHerokuappLoginAppch_PScreenshotFail_iAnnotationTransformerListener_Test extends BaseTest {


    @Parameters({"username","password"})
    @Test
    public void LoginTest(String user, String pass) throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.OpenWelcomePage().goToLoginPage().enterUserAndPassword(user,pass).clickLogin().verifyIfSuccessAttempt2();
    }


}
