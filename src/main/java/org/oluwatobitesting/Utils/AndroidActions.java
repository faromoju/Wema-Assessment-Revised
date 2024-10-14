package org.oluwatobitesting.Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;

public class AndroidActions extends AppiumUtilities{
    //Declare AndroidDriver
    AndroidDriver driver;

    //Class Constructor
    public AndroidActions(AndroidDriver driver) {
        super(driver);

        this.driver = driver;
    }

    public void startActivity(String activityName) {
        ((JavascriptExecutor)driver).executeScript("mobile: startActivity",
                ImmutableMap.of("intent", activityName));
    }
}
