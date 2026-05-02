package com.tests.PracticeTests;

import com.tests.Base.BaseTest;
import com.tests.PageObjects.WelcomePage;
import com.tests.Utilities.PropertyManager;
import org.testng.annotations.Test;

public class MyHerokuappLoginAppch_Property_Test extends BaseTest {


    @Test
    public void LoginTest() throws InterruptedException {

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.OpenWelcomePage().goToLoginPage().
                enterUserAndPassword(PropertyManager.getInstance().getProperty("username"),
                        PropertyManager.getInstance().getProperty("password")).clickLogin().verifyIfSuccessAttempt2();
    }


}
