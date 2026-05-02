package com.tests.Utilities;

import com.tests.Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtilManager extends BaseTest
{
    public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
        File sourcefile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("_yyyy_MM_dd_HHmmss").format(new Date());
        String screenshotPath  = System.getProperty("user.dir")+"/screenshots/"+  testName + timestamp + ".png";
        File destFile = new File(screenshotPath);
        FileUtils.copyFile(sourcefile,destFile);
        return screenshotPath;

    }
}
