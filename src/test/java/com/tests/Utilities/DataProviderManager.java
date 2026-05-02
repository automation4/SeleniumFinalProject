package com.tests.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviderManager {

    @DataProvider(name = "LoginCreds_UsingOBJArray")
    protected static Object[][] LoginCred(){
        return new Object[][]
                {
                        {"tomsmith","SuperSecretPassword!"},
                        {"tomsmit2h","SuperS3ecretPassword!"}
                };
    }



}
