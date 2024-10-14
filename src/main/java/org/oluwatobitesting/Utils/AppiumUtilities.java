package org.oluwatobitesting.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AppiumUtilities {
    //Declare Variables
    AndroidDriver driver;
    static WebDriverWait wait;
    static AppiumDriverLocalService appiumService;

    public AppiumUtilities(AndroidDriver driver) {
        //Set driver object from wherever class object is called
        this.driver = driver;
    }

    public AppiumUtilities() {
    }

    public static AppiumDriverLocalService appiumService(String ipAddress, int port) {
        //Appium Server Set Up
        //Main.js File path should be set appropriately
        //Port can also be set
        return appiumService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:/Users/farom/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAddress).usingPort(port)
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload").build();
    };

    public void waitUntilVisible(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPresenceById(String id) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
        //Folder Location for Screenshots
        File screenshotFolder = new File("reports/Screenshots");

        //Screenshot Function
        //Store Screenshot with File Method
        File screenshot = driver.getScreenshotAs(OutputType.FILE);

        //Set Destination for Screenshot to be stored locally
        String screenshotDestination = screenshotFolder.getAbsolutePath()+"/"+testCaseName+".png";

        //Get Screenshot from File Method and store in Destination
        FileUtils.copyFile(screenshot, new File(screenshotDestination));

        //Return Screenshot Destination for Reporter
        return screenshotDestination;
    }
}
