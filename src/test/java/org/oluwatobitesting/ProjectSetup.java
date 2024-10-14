package org.oluwatobitesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import static org.oluwatobitesting.Utils.AppiumUtilities.appiumService;

public class ProjectSetup {
    public static AndroidDriver driver;
    static String appPackage;
    static Properties testProperties;
    static FileInputStream propertiesFile;
    static String ipAddress;
    static String port;

    @BeforeClass(alwaysRun = true)
    public static void appiumStartup() throws URISyntaxException, IOException {
        //Set Properties File Path
        File propertiesFilePath = new File("src/main/java/org/oluwatobitesting/resources/data.Properties");

        //Test Properties
        testProperties = new Properties();
        propertiesFile = new FileInputStream(propertiesFilePath.getAbsolutePath());
        testProperties.load(propertiesFile);
        ipAddress = System.getProperty("ipAddress") !=null ? System.getProperty("ipAddress") : testProperties.getProperty("ipAddress");
        port = System.getProperty("port") !=null ? System.getProperty("port") : testProperties.getProperty("port");
        String deviceName = System.getProperty("deviceName") !=null ? System.getProperty("deviceName")
                : testProperties.getProperty("androidDeviceName");
        String deviceUdid = System.getProperty("Udid") !=null ? System.getProperty("Udid") : testProperties.getProperty("androidDeviceUdid");

        //Start Appium Server
        //Comment out this line if server will be started manually
        appiumService(ipAddress, Integer.parseInt(port)).start();

        //Set Test Apk File Path
        File alatTestApk = new File("app/QA_Dev_test_test_build.apk");

        //Set Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setApp(alatTestApk.getAbsolutePath());
        options.setUdid(deviceUdid);

        //Instantiate AndroidDriver
        driver = new AndroidDriver(appiumService(ipAddress, Integer.parseInt(port)).getUrl(), options);

        //Get Package Name
        appPackage = driver.getCurrentPackage();

        //Set Implicit Wait for all DOM Elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass(alwaysRun = true)
    public static void appiumShutdown() {
        //Close App
        driver.quit();

        //Shutdown Appium Server
        //Comment out this line if server will be started manually
        appiumService(ipAddress, Integer.parseInt(port)).stop();
    }
}
