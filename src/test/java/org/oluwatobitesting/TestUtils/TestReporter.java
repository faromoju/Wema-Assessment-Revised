package org.oluwatobitesting.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestReporter{
    //Test Reporter Method
    public static ExtentReports testReporterConfig() throws IOException {
        //Set Properties File Path
        File propertiesFilePath = new File("src/main/java/org/oluwatobitesting/resources/data.Properties");

        //Test Properties
        Properties testProperties = new Properties();
        FileInputStream propertiesFile = new FileInputStream(propertiesFilePath.getAbsolutePath());
        testProperties.load(propertiesFile);
        String qaEngineerName = testProperties.getProperty("qaEngineerName");

        //Set Test Report File Location
        File reportFile = new File("reports/index.html");

        //Extent Reporter Configuration
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFile.getAbsolutePath());
        reporter.config().setReportName("Wema Assessment Results");
        reporter.config().setDocumentTitle("Test Results");

        //Extent Report Attachment for Extent Reporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA Engineer", qaEngineerName);

        return extent;
    }
}
