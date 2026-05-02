package com.tests.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static ExtentReports extentReport;

    public static ExtentReports getReport() {
        if (extentReport == null) {
            return createReport();
        }
        return extentReport;

    }

    public static ExtentReports createReport(){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/java/com/tests/ExtentReports/ExtentManager.html");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Automation Run");
        extentSparkReporter.config().setEncoding("utf-8");
        extentReport = new ExtentReports();
        extentReport.setSystemInfo("Oraganization","Lets Code it");
        extentReport.setSystemInfo("Automation Framwork","Selenium WebDriver");
        extentReport.setSystemInfo("Windows","10");
        extentReport.attachReporter(extentSparkReporter);
        return extentReport;
    }
}
