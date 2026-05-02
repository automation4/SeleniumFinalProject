package com.tests.PracticeTests;

import com.tests.Base.BaseTest;
import com.tests.PageObjects.WelcomePage;
import com.tests.Utilities.DataProviderManager;
import org.testng.annotations.Test;

public class MyHerokuappLoginAppchDP_Test extends BaseTest {


    @Test(dataProvider="LoginCreds_UsingOBJArray",dataProviderClass = DataProviderManager.class)
    public void LoginTest(String user, String pass) throws InterruptedException {

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.OpenWelcomePage().goToLoginPage().
                enterUserAndPassword(user,pass).
                clickLogin().verifyIfSuccessAttempt2();
    }


}
