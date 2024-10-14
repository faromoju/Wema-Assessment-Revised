package org.oluwatobitesting;

import org.oluwatobitesting.Pages.GetStartedPage;
import org.oluwatobitesting.Pages.LandingPage;
import org.oluwatobitesting.Pages.LogInPage;
import org.oluwatobitesting.Pages.SignUpAsAffiliatePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpAsAffiliateIT extends ProjectSetup{
    //Page Objects
    static LandingPage landingPageObject;
    static GetStartedPage getStartedPageObject;
    static SignUpAsAffiliatePage signUpAsAffiliatePageObject;
    static LogInPage logInPageObject;

    @BeforeClass(alwaysRun = true)
    public void signUpAsAffiliatePageTraverse() {
        //Initialize Page Objects
        landingPageObject = new LandingPage(driver);
        getStartedPageObject = new GetStartedPage(driver);
        signUpAsAffiliatePageObject = new SignUpAsAffiliatePage(driver);
        logInPageObject = new LogInPage(driver);

        //Tap Get Started Button
        landingPageObject.tapGetStartedButton();

        //Wait for Get Started Page to be fully loaded
        getStartedPageObject.waitUntilVisible(getStartedPageObject.welcomeTitle.get(0));

        //Select Sign Up As An Affiliate Option and Continue
        getStartedPageObject.tapSignUpAsAffiliate();
        getStartedPageObject.tapContinueButton();
    }

    @Test(priority = 1, enabled = true, dataProvider = "testData")
    public static void pageNumberVerification(String affiliateOption, String firstName, String lastName,
                                              String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                              String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Assertion for Page Number
        Assert.assertEquals(signUpAsAffiliatePageObject.getPageNumberText(), "2/2");
    }

    @Test(priority = 2, enabled = true, dataProvider = "testData")
    public static void signUpWithoutAffiliate(String affiliateOption, String firstName, String lastName,
                                              String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                              String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Affiliate Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getAffiliateErrorText(), "'Organization Id' must not be empty.");
    }

    @Test(priority = 3, enabled = true, dataProvider = "testData")
    public static void selectAffiliateOption(String affiliateOption, String firstName, String lastName,
                                             String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                             String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Select Affiliate from Dropdown
        signUpAsAffiliatePageObject.tapAffiliateDropdown();
        signUpAsAffiliatePageObject.selectAffiliateOption(affiliateOption);

        //Assertion for Selected Affiliate
        Assert.assertEquals(signUpAsAffiliatePageObject.getAffiliateText(), affiliateOption);
    }

    @Test(priority = 4, enabled = true, dataProvider = "testData")
    public static void signUpWithoutFirstName(String affiliateOption, String firstName, String lastName,
                                              String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                              String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for First Name Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getFirstNameErrorText(), "'First name' must not be empty.");
    }

    @Test(priority = 5, enabled = true, dataProvider = "testData")
    public static void enterFirstName(String affiliateOption, String firstName, String lastName,
                                      String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                      String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter First Name
        signUpAsAffiliatePageObject.enterFirstName(firstName);

        //Assertion for First Name
        Assert.assertEquals(signUpAsAffiliatePageObject.getFirstNameText(), firstName);

        //Clear First Name
        signUpAsAffiliatePageObject.clearFirstName();
    }

    @Test(priority = 6, enabled = true, dataProvider = "testData")
    public static void signUpWithoutLastName(String affiliateOption, String firstName, String lastName,
                                             String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                             String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Last Name Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getLastNameErrorText(), "'Last name' must not be empty.");
    }

    @Test(priority = 7, enabled = true, dataProvider = "testData")
    public static void enterLastName(String affiliateOption, String firstName, String lastName,
                                     String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                     String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Last Name
        signUpAsAffiliatePageObject.enterLastName(lastName);

        //Assertion for Last Name
        Assert.assertEquals(signUpAsAffiliatePageObject.getLastNameText(), lastName);

        //Clear Last Name
        signUpAsAffiliatePageObject.clearLastName();
    }

    @Test(priority = 8, enabled = true, dataProvider = "testData")
    public static void signUpWithoutEmailAddress(String affiliateOption, String firstName, String lastName,
                                                 String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                                 String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Empty Email Address Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getEmptyEmailErrorText(), "'Email' must not be empty.");
    }

    @Test(priority = 9, enabled = true, dataProvider = "testData")
    public static void enterInvalidEmailAddress(String affiliateOption, String firstName, String lastName,
                                                String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                                String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Email Address
        signUpAsAffiliatePageObject.enterEmailAddress(invalidEmail);

        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Invalid Email Address Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getInvalidEmailErrorText(), "'Email' is not a valid email address.");

        //Clear Email Address
        signUpAsAffiliatePageObject.clearEmailAddress();
    }

    @Test(priority = 10, enabled = true, dataProvider = "testData")
    public static void enterValidEmailAddress(String affiliateOption, String firstName, String lastName,
                                              String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                              String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Email Address
        signUpAsAffiliatePageObject.enterEmailAddress(validEmail);

        //Assertion for Email Address
        Assert.assertEquals(signUpAsAffiliatePageObject.getEmailAddressText(), validEmail);

        //Clear Email Address
        signUpAsAffiliatePageObject.clearEmailAddress();
    }

    @Test(priority = 11, enabled = true, dataProvider = "testData")
    public static void signUpWithoutPassword(String affiliateOption, String firstName, String lastName,
                                             String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                             String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Empty Password Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getEmptyPasswordErrorText(), "'Password' must not be empty.");
    }

    @Test(priority = 12, enabled = true, dataProvider = "testData")
    public static void enterInvalidPassword(String affiliateOption, String firstName, String lastName,
                                            String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                            String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Password
        signUpAsAffiliatePageObject.enterPassword(invalidPassword);

        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Invalid Password Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getInvalidPasswordErrorText(), "The length of 'Password' must be at least 8 characters. You entered 7 characters.");

        //Clear Password
        signUpAsAffiliatePageObject.clearPassword();
    }

    @Test(priority = 13, enabled = true, dataProvider = "testData")
    public static void enterValidPassword(String affiliateOption, String firstName, String lastName,
                                          String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                          String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Password
        signUpAsAffiliatePageObject.enterPassword(validPassword);

        //Assertion for Password
        Assert.assertEquals(signUpAsAffiliatePageObject.getPasswordText(), validPassword);

        //Clear Password
        signUpAsAffiliatePageObject.clearPassword();
    }

    @Test(priority = 14, enabled = true, dataProvider = "testData")
    public static void revealPassword(String affiliateOption, String firstName, String lastName,
                                      String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                      String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Password
        signUpAsAffiliatePageObject.enterPassword(validPassword);

        //Reveal the Entered Password
        signUpAsAffiliatePageObject.revealPassword();

        //Assertion that Password is revealed
        Assert.assertEquals(signUpAsAffiliatePageObject.verifyPasswordReveal(), "false");

        //Conceal the Entered Password
        signUpAsAffiliatePageObject.revealPassword();

        //Assertion that Password is concealed
        Assert.assertEquals(signUpAsAffiliatePageObject.verifyPasswordReveal(), "true");

        //Clear Password
        signUpAsAffiliatePageObject.clearPassword();
    }

    @Test(priority = 15, enabled = true, dataProvider = "testData")
    public static void signUpWithoutRepeatPassword(String affiliateOption, String firstName, String lastName,
                                                   String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                                   String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Empty Repeat Password Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getEmptyRepeatPasswordErrorText(), "'Repeat Password' must not be empty.");
    }

    @Test(priority = 16, enabled = true, dataProvider = "testData")
    public static void enterInvalidRepeatPassword(String affiliateOption, String firstName, String lastName,
                                                  String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                                  String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Password
        signUpAsAffiliatePageObject.enterPassword(invalidPassword);

        //Enter Repeat Password
        signUpAsAffiliatePageObject.enterRepeatPassword(invalidPassword);

        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Invalid Repeat Password Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getInvalidRepeatPasswordErrorText(), "The length of 'Repeat Password' must be at least 8 characters. You entered 7 characters.");

        //Clear Password and Repeat Password
        signUpAsAffiliatePageObject.clearPassword();
        signUpAsAffiliatePageObject.clearRepeatPassword();
    }

    @Test(priority = 17, enabled = true, dataProvider = "testData")
    public static void notMatchRepeatPassword(String affiliateOption, String firstName, String lastName,
                                              String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                              String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Password
        signUpAsAffiliatePageObject.enterPassword(validPassword);

        //Enter Repeat Password
        signUpAsAffiliatePageObject.enterRepeatPassword(notMatchPassword);

        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Wait for loading to end
        signUpAsAffiliatePageObject.waitUntilVisible(signUpAsAffiliatePageObject.welcomeAffiliateTitle);

        //Assertion for Not Match Repeat Password Error Message
        Assert.assertEquals(signUpAsAffiliatePageObject.getRepeatPasswordNotMatchErrorText(), "Password not equal");

        //Clear Password and Repeat Password
        signUpAsAffiliatePageObject.clearPassword();
        signUpAsAffiliatePageObject.clearRepeatPassword();
    }

    @Test(priority = 18, enabled = true, dataProvider = "testData")
    public static void enterValidRepeatPassword(String affiliateOption, String firstName, String lastName,
                                                String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                                String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Repeat Password
        signUpAsAffiliatePageObject.enterRepeatPassword(validPassword);

        //Assertion for Repeat Password
        Assert.assertEquals(signUpAsAffiliatePageObject.getRepeatPasswordText(), validPassword);

        //Clear Repeat Password
        signUpAsAffiliatePageObject.clearRepeatPassword();
    }

    @Test(priority = 19, enabled = true, dataProvider = "testData")
    public static void revealRepeatPassword(String affiliateOption, String firstName, String lastName,
                                            String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                            String notMatchPassword, String existingEmail, String secondEmailAddress) {
        //Enter Repeat Password
        signUpAsAffiliatePageObject.enterRepeatPassword(validPassword);

        //Reveal the Entered Repeat Password
        signUpAsAffiliatePageObject.revealRepeatPassword();

        //Assertion that Repeat Password is revealed
        Assert.assertEquals(signUpAsAffiliatePageObject.verifyRepeatPasswordReveal(), "false");

        //Conceal the Entered Repeat Password
        signUpAsAffiliatePageObject.revealRepeatPassword();

        //Assertion that Repeat Password is revealed
        Assert.assertEquals(signUpAsAffiliatePageObject.verifyRepeatPasswordReveal(), "true");

        //Clear Repeat Password
        signUpAsAffiliatePageObject.clearRepeatPassword();
    }

    @Test(priority = 20, enabled = true, dataProvider = "testData")
    public static void signUpWithExistingEmailAddress(String affiliateOption, String firstName, String lastName,
                                                      String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                                      String notMatchPassword, String existingEmail, String secondEmailAddress) {

        //Complete Sign Up Form
        signUpAsAffiliatePageObject.tapAffiliateDropdown();
        signUpAsAffiliatePageObject.selectAffiliateOption(affiliateOption);
        signUpAsAffiliatePageObject.enterFirstName(firstName);
        signUpAsAffiliatePageObject.enterLastName(lastName);
        signUpAsAffiliatePageObject.enterEmailAddress(existingEmail);
        signUpAsAffiliatePageObject.enterPassword(validPassword);
        signUpAsAffiliatePageObject.enterRepeatPassword(validPassword);

        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Assertion for Existing Email Address
        Assert.assertEquals(signUpAsAffiliatePageObject.getSignUpMessageText(), existingEmail + " is connected to a profile on ALAT Office.");

        //Tap Done Button
        signUpAsAffiliatePageObject.tapDoneButton();

        //Clear Email Address
        signUpAsAffiliatePageObject.clearEmailAddress();
    }

    @Test(priority = 21, enabled = true, dataProvider = "testData")
    public static void signUpWithValidDetails(String affiliateOption, String firstName, String lastName,
                                              String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                              String notMatchPassword, String existingEmail, String secondEmailAddress) {

        //Complete Sign Up Form
        signUpAsAffiliatePageObject.enterEmailAddress(validEmail);

        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Assertion for Successful Agent Onboarding
        Assert.assertEquals(signUpAsAffiliatePageObject.getSignUpMessageText(), "Onboarding Successful");

        //Tap Done Button
        signUpAsAffiliatePageObject.tapDoneButton();
    }

    @Test(priority = 22, enabled = true, dataProvider = "testData")
    public static void verifyAgentOnboardingEndToEnd(String affiliateOption, String firstName, String lastName,
                                              String invalidEmail, String validEmail, String invalidPassword, String validPassword,
                                              String notMatchPassword, String existingEmail, String secondEmailAddress) {

        //Navigate to Affiliate Sign Up
        landingPageObject.tapGetStartedButton();
        getStartedPageObject.waitUntilVisible(getStartedPageObject.welcomeTitle.get(0));
        getStartedPageObject.tapSignUpAsAffiliate();
        getStartedPageObject.tapContinueButton();

        //Complete Sign Up Form
        signUpAsAffiliatePageObject.tapAffiliateDropdown();
        signUpAsAffiliatePageObject.selectAffiliateOption(affiliateOption);
        signUpAsAffiliatePageObject.enterFirstName(firstName);
        signUpAsAffiliatePageObject.enterLastName(lastName);
        signUpAsAffiliatePageObject.enterEmailAddress(secondEmailAddress);
        signUpAsAffiliatePageObject.enterPassword(validPassword);
        signUpAsAffiliatePageObject.enterRepeatPassword(validPassword);

        //Tap Sign Up Button
        signUpAsAffiliatePageObject.tapSignUpButton();

        //Assertion for Successful Agent Onboarding
        Assert.assertEquals(signUpAsAffiliatePageObject.getSignUpMessageText(), "Onboarding Successful");

        //Tap Done Button
        signUpAsAffiliatePageObject.tapDoneButton();

        //Proceed to Log In with Onboarded Agent
        landingPageObject.tapLogInButton();
        logInPageObject.inputEmailAddress(secondEmailAddress);
        logInPageObject.inputPassword(validPassword);
        logInPageObject.tapLoginButton();
        logInPageObject.waitForPresenceById(logInPageObject.errorPopUpTextId);

        //Assertion For Log In with created Agent
        Assert.assertEquals(logInPageObject.logInErrorText(), "Hello "+ firstName +", your profile is yet to be approved.");
    }

    @DataProvider()
    public Object[][] testData() {
        int userNumber = (int) Math.floor(Math.random() * 100001);
        int e2eUserNumber = (int) Math.floor(Math.random() * 100001);

        return new Object[][] {
                {
                    "WEMA", "New", "User", "test@", "tester"+userNumber+"@alatmail.com",
                        "Passing", "Passwingword50", "Passingword50", "test@user1.com", "tester"+e2eUserNumber+"@alatmail.com"
                }
        };
    }
}
