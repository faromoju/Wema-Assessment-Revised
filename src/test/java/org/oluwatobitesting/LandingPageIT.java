package org.oluwatobitesting;

import org.oluwatobitesting.Pages.GetStartedPage;
import org.oluwatobitesting.Pages.LandingPage;
import org.oluwatobitesting.Pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LandingPageIT extends ProjectSetup{
    //Page Objects
    static LandingPage landingPageObject;
    static LogInPage logInPageObject;
    static GetStartedPage getStartedPageObject;

    @BeforeClass(alwaysRun = true)
    public void pageObjects() {
        //Initialize Page Object
        landingPageObject = new LandingPage(driver);
        logInPageObject = new LogInPage(driver);
        getStartedPageObject = new GetStartedPage(driver);
    }

    @Test(priority = 1)
    public static void logInButtonTest() {
        //Wait for Page to be Fully Loaded
        landingPageObject.waitUntilVisible(landingPageObject.landingPageIcon.get(0));

        //Tap Log In Button
        landingPageObject.tapLogInButton();

        //Assertion For Login Page
        Assert.assertTrue(logInPageObject.welcomeBackTitle.size() >= 1);
    }

    @Test(priority = 2)
    public static void getStartedButtonTest() {
        //Wait for Page to be Fully Loaded
        landingPageObject.waitUntilVisible(landingPageObject.landingPageIcon.get(0));

        //Tap Get Started Button
        landingPageObject.tapGetStartedButton();

        //Assertion For Get Started Page
        Assert.assertTrue(getStartedPageObject.welcomeTitle.size() >= 1);
    }

    @AfterMethod(alwaysRun = true)
    public static void resetApp() {
        //Terminate App
        driver.terminateApp(appPackage);

        //Launch App
        driver.activateApp(appPackage);
    }
}
