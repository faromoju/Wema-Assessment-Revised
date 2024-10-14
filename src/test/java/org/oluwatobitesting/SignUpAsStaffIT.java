package org.oluwatobitesting;

import org.oluwatobitesting.Pages.GetStartedPage;
import org.oluwatobitesting.Pages.LandingPage;
import org.oluwatobitesting.Pages.SignUpAsStaffPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpAsStaffIT extends ProjectSetup{
    //Page Objects
    static LandingPage landingPageObject;
    static GetStartedPage getStartedPageObject;
    static SignUpAsStaffPage signUpAsStaffPageObject;

    @BeforeClass(alwaysRun = true)
    public void signUpAsStaffPageTraverse() {
        //Initialize Page Objects
        landingPageObject = new LandingPage(driver);
        getStartedPageObject = new GetStartedPage(driver);
        signUpAsStaffPageObject = new SignUpAsStaffPage(driver);

        //Tap Get Started Button
        landingPageObject.tapGetStartedButton();

        //Wait for Get Started Page to be fully loaded
        getStartedPageObject.waitUntilVisible(getStartedPageObject.welcomeTitle.get(0));

        //Select Sign Up As A Staff Option and Continue
        getStartedPageObject.tapSignUpAsStaff();
        getStartedPageObject.tapContinueButton();
    }

    @Test(priority = 1, enabled = true, dataProvider = "testData")
    public void verifyWithoutStaffID(String staffID, String boundaryStaffID) {
        //Tap Verify Staff ID Button
        signUpAsStaffPageObject.tapVerifyStaffIDButton();

        //Assertion for Empty Staff ID Error Message
        Assert.assertEquals(signUpAsStaffPageObject.getStaffIDErrorText(), "Staff ID is required");
    }

    @Test(priority = 2, enabled = true, dataProvider = "testData")
    public void enterStaffID(String staffID, String boundaryStaffID) {
        //Enter Staff ID
        signUpAsStaffPageObject.enterStaffID(staffID);

        //Assertion for Entered Staff ID
        Assert.assertEquals(signUpAsStaffPageObject.getStaffIDText(), staffID);

        //Clear Staff ID
        signUpAsStaffPageObject.clearStaffID();
    }

    @Test(priority = 3, enabled = true, dataProvider = "testData")
    public void staffIDCharacterLimit(String staffID, String boundaryStaffID) {
        //Enter Staff ID
        signUpAsStaffPageObject.enterStaffID(boundaryStaffID);

        //Assertion that Entered Staff ID cannot be more than 15 Characters
        Assert.assertEquals(signUpAsStaffPageObject.getStaffIDText(), "123456789QNWKYS");

        //Clear Staff ID
        signUpAsStaffPageObject.clearStaffID();
    }

    @Test(priority = 4, enabled = true, dataProvider = "testData")
    public void verifyNonExistentStaffID(String staffID, String boundaryStaffID) {
        //Enter Staff ID
        signUpAsStaffPageObject.enterStaffID(staffID);

        //Tap Verify Staff ID Button
        signUpAsStaffPageObject.tapVerifyStaffIDButton();

        //Assertion for Staff ID not Found
        Assert.assertEquals(signUpAsStaffPageObject.getStaffIDNotFoundErrorText(), "No matching record found.");

        //Tap Done Button
        signUpAsStaffPageObject.tapDoneButton();

        //Clear Staff ID
        signUpAsStaffPageObject.clearStaffID();
    }

    @Test(priority = 5, enabled = true, dataProvider = "testData")
    public void navigateBackToGetStartedPage(String staffID, String boundaryStaffID) {
        //Enter Staff ID
        signUpAsStaffPageObject.enterStaffID(staffID);

        //Tap Back Button
        signUpAsStaffPageObject.tapBackButton();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                {
                    "SJ1080", "123456789QNWKYSDREWRBBN"
                }
        };
    }
}
