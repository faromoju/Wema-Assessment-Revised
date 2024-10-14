package org.oluwatobitesting;

import org.oluwatobitesting.Pages.LandingPage;
import org.oluwatobitesting.Pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageIT extends ProjectSetup{
    //Page Objects
    static LandingPage landingPageObject;
    static LogInPage logInPageObject;

    @BeforeClass(alwaysRun = true)
    public void loginPageTraverse(){
        //Initialize Page Objects
        landingPageObject = new LandingPage(driver);
        logInPageObject = new LogInPage(driver);

        //Tap Log In Button
        landingPageObject.tapLogInButton();

        //Wait for Log In Page to be fully loaded
        logInPageObject.waitUntilVisible(logInPageObject.welcomeBackTitle.get(0));
    }

    @Test(priority = 1, dataProvider = "testData", enabled = true)
    public static void emailAddressFieldTest(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Email Address
        logInPageObject.inputEmailAddress(validEmailAddress);

        //Assertion for Email Address Field
        Assert.assertEquals(logInPageObject.emailAddressValue(), validEmailAddress);

        //Clear Email Address
        logInPageObject.clearEmailAddress();
    }

    @Test(priority = 2, dataProvider = "testData", enabled = true)
    public static void passwordFieldTest(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Password
        logInPageObject.inputPassword(validPassword);

        //Assertion for Password Field
        Assert.assertEquals(logInPageObject.passwordValue(), validPassword);

        //Clear Password
        logInPageObject.clearPassword();
    }

    @Test(priority = 3, dataProvider = "testData", enabled = true)
    public static void passwordToggleTest(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Password
        logInPageObject.inputPassword(validPassword);

        //Tap Password Toggle
        logInPageObject.tapPasswordToggle();

        //Assertion for Password Toggle
        Assert.assertEquals(logInPageObject.passwordStatus(), "false");

        //Tap Password Toggle
        logInPageObject.tapPasswordToggle();

        //Assertion for Password Toggle
        Assert.assertEquals(logInPageObject.passwordStatus(), "true");

        //Clear Password
        logInPageObject.clearPassword();
    }

    @Test(priority = 4, dataProvider = "testData", enabled = true)
    public static void loginWithoutEmailAddress(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Password
        logInPageObject.inputPassword(validPassword);

        //Tap Login Button
        logInPageObject.tapLoginButton();

        //Assertion for Failed Login
        Assert.assertEquals(logInPageObject.noEmailErrorText(), "'Email' must not be empty.");

        //Clear Password
        logInPageObject.clearPassword();
    }

    @Test(priority = 5, dataProvider = "testData", enabled = true)
    public static void loginWithInvalidEmailAddress(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Email Address
        logInPageObject.inputEmailAddress(invalidEmailAddress);

        //Tap Login Button
        logInPageObject.tapLoginButton();

        //Assertion for Failed Login
        Assert.assertEquals(logInPageObject.invalidEmailErrorText(), "'Email' is not a valid email address.");

        //Clear Email Address
        logInPageObject.clearEmailAddress();
    }

    @Test(priority = 6, dataProvider = "testData", enabled = true)
    public static void loginWithoutPassword(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Email Address
        logInPageObject.inputEmailAddress(validEmailAddress);

        //Tap Login Button
        logInPageObject.tapLoginButton();

        //Assertion for Failed Login
        Assert.assertEquals(logInPageObject.noPasswordErrorText(), "'Password' must not be empty.");

        //Clear Email Address
        logInPageObject.clearEmailAddress();
    }

    @Test(priority = 7, dataProvider = "testData", enabled = true)
    public static void loginWithNonExistentEmailAddress(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Email Address
        logInPageObject.inputEmailAddress(nonExistentEmailAddress);

        //Enter Password
        logInPageObject.inputPassword(validPassword);

        //Tap Login Button
        logInPageObject.tapLoginButton();

        //Wait for Error Pop Up
        logInPageObject.waitForPresenceById(logInPageObject.errorPopUpTextId);

        //Assertion for Failed Login
        Assert.assertTrue(logInPageObject.logInError.size() >= 1);

        //Tap Done Button
        logInPageObject.tapDoneButton();

        //Clear Email Address and Password
        logInPageObject.clearEmailAddress();
        logInPageObject.clearPassword();
    }

    @Test(priority = 8, dataProvider = "testData", enabled = true)
    public static void loginWithInvalidPassword(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Email Address
        logInPageObject.inputEmailAddress(validEmailAddress);

        //Enter Password
        logInPageObject.inputPassword(invalidPassword);

        //Tap Login Button
        logInPageObject.tapLoginButton();

        //Wait for Error Pop Up
        logInPageObject.waitForPresenceById(logInPageObject.errorPopUpTextId);

        //Assertion for Failed Login
        Assert.assertTrue(logInPageObject.logInError.size() >= 1);

        //Tap Done Button
        logInPageObject.tapDoneButton();

        //Clear Email Address and Password
        logInPageObject.clearEmailAddress();
        logInPageObject.clearPassword();
    }

    @Test(priority = 9, dataProvider = "testData", enabled = true)
    public static void loginWithValidCredentials(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Enter Email Address
        logInPageObject.inputEmailAddress(validEmailAddress);

        //Enter Password
        logInPageObject.inputPassword(validPassword);

        //Tap Login Button
        logInPageObject.tapLoginButton();

        //Wait for Pop Up
        logInPageObject.waitForPresenceById(logInPageObject.errorPopUpTextId);

        //Assertion for Successful Login
        Assert.assertFalse(logInPageObject.logInError.size() >= 1);
    }

    @Test(priority = 10, dataProvider = "testData", enabled = true)
    public static void navigateBackToLandingPage(
            String validEmailAddress, String validPassword, String invalidEmailAddress, String nonExistentEmailAddress, String invalidPassword) {
        //Tap Done Button
        logInPageObject.tapDoneButton();

        //Clear Email Address and Password
        logInPageObject.clearEmailAddress();
        logInPageObject.clearPassword();

        //Enter Email Address
        logInPageObject.inputEmailAddress(validEmailAddress);

        //Enter Password
        logInPageObject.inputPassword(validPassword);

        //Tap Login Button
        logInPageObject.tapLoginButton();

        //Wait for Pop Up
        logInPageObject.waitForPresenceById(logInPageObject.errorPopUpTextId);

        //Tap Done Button
        logInPageObject.tapDoneButton();

        //Tap Back Button
        logInPageObject.tapPageBackButton();

        //Assertion for Landing Page
        Assert.assertTrue(landingPageObject.landingPageIcon.size() >= 1);
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {
                    "test@user1.com", "Password1.", "test", "test@user2020.com", "Passingword1"
                }
        };
    }
}
