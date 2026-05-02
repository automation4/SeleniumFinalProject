package com.tests.MyListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    int count = 0;
    int retryMaxLimit = 2;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<retryMaxLimit){
            count++;
            return true;
        }
        return false;
    }
}
