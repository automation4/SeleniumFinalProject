package com.tests.PracticeTests;

import com.tests.Base.BaseTest;
import com.tests.PageObjects.WelcomePage;
import com.tests.Utilities.ExcelManager;
import org.testng.annotations.Test;

public class MyHerokuappLoginAppch_ExcelData_Test extends BaseTest {

    @Test(dataProvider = "Logindata_Excel", dataProviderClass = ExcelManager.class)
    public void LoginTest(String user, String pass) throws InterruptedException {

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.OpenWelcomePage().goToLoginPage().enterUserAndPassword(user,pass).clickLogin().verifyIfSuccessAttempt2();
    }


}
