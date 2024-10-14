package org.oluwatobitesting;

import org.oluwatobitesting.Pages.GetStartedPage;
import org.oluwatobitesting.Pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetStartedPageIT extends ProjectSetup{
    //Page Objects
    static LandingPage landingPageObject;
    static GetStartedPage getStartedPageObject;

    @BeforeClass(alwaysRun = true)
    public void getStartedPageTraverse(){
        //Initialize Page Objects
        landingPageObject = new LandingPage(driver);
        getStartedPageObject = new GetStartedPage(driver);

        //Tap Log In Button
        landingPageObject.tapGetStartedButton();

        //Wait for Get Started Page to be fully loaded
        getStartedPageObject.waitUntilVisible(getStartedPageObject.welcomeTitle.get(0));
    }

    @Test(priority = 1, enabled = true)
    public static void signUpAsAffiliateOption() {
        //Select Sign Up As An Affiliate Option
        getStartedPageObject.tapSignUpAsAffiliate();

        //Deselect Sign Up As An Affiliate Button
        getStartedPageObject.tapSignUpAsAffiliate();
    }

    @Test(priority = 2, enabled = true)
    public static void signUpAsStaffOption() {
        //Select Sign Up As A Staff Option
        getStartedPageObject.tapSignUpAsStaff();

        //Deselect Sign Up As A Staff Button
        getStartedPageObject.tapSignUpAsStaff();
    }

    @Test(priority = 3, enabled = true)
    public static void signUpWithoutSelectingOption() {
        //Tap Continue Button
        getStartedPageObject.tapContinueButton();

        //Assertion to not be allowed to proceed
        Assert.assertTrue(getStartedPageObject.welcomeTitle.size() >= 1);
    }

    @Test(priority = 4, enabled = true)
    public static void signUpWithSelectingBothOptions() {
        //Select Sign Up As An Affiliate Option
        getStartedPageObject.tapSignUpAsAffiliate();

        //Select Sign Up As A Staff Option
        getStartedPageObject.tapSignUpAsStaff();
    }

    @Test(priority = 5, enabled = true)
    public static void navigateBackToLandingPage() {
        //Select Sign Up As An Affiliate Option
        getStartedPageObject.tapSignUpAsAffiliate();

        //Select Sign Up As A Staff Option
        getStartedPageObject.tapSignUpAsStaff();

        //Tap Back Button
        getStartedPageObject.tapBackButton();

        //Assertion for Landing Page
        Assert.assertTrue(landingPageObject.landingPageIcon.size() >= 1);
    }
}
