package org.oluwatobitesting.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jspecify.annotations.Nullable;
import org.oluwatobitesting.Utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignUpAsAffiliatePage extends AndroidActions {
    //Declare AndroidDriver
    AndroidDriver driver;

    //Class Constructor
    public SignUpAsAffiliatePage(AndroidDriver driver) {
        super(driver);

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Locators
    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/textView2")
    public WebElement welcomeAffiliateTitle;

    public String welcomeTitleId = "com.wemabank.alat.office.alat_qa_test:id/textView2";

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/app_bar_title")
    private WebElement pageNumber;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/item")
    private WebElement affiliateDropdown;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/signUpButton")
    private WebElement signUpButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Organization Id' must not be empty.\"]")
    private WebElement affiliateErrorMessage;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/firstNameEditText")
    private WebElement firstNameField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'First name' must not be empty.\"]")
    private WebElement firstNameErrorMessage;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/lastNameEditText")
    private WebElement lastNameField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Last name' must not be empty.\"]")
    private WebElement lastNameErrorMessage;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/emailAddressEditText")
    private WebElement emailAddressField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Email' must not be empty.\"]")
    private WebElement emptyEmailAddressErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Email' is not a valid email address.\"]")
    private WebElement invalidEmailAddressErrorMessage;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/passwordTextInputEditText")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Password' must not be empty.\"]")
    private WebElement emptyPasswordErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"The length of 'Password' must be at least 8 characters. You entered 7 characters.\"]")
    private WebElement invalidPasswordErrorMessage;

    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[1]")
    private WebElement passwordCheckIcon;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/repasswordTextInputEditText")
    private WebElement repeatPasswordField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Repeat Password' must not be empty.\"]")
    private WebElement emptyRepeatPasswordErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"The length of 'Repeat Password' must be at least 8 characters. You entered 7 characters.\"]")
    private WebElement invalidRepeatPasswordErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Password not equal\"]")
    private WebElement repeatPasswordNotMatchErrorMessage;

    @AndroidFindBy(xpath = "(//android.widget.ImageButton[@content-desc=\"Show password\"])[2]")
    private WebElement repeatPasswordCheckIcon;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/status_text")
    private WebElement signUpErrorMessage;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/status_btn_text")
    private WebElement doneButton;

    //Actions
    public String getPageNumberText() {
        return pageNumber.getText();
    }

    public void tapAffiliateDropdown() {
        affiliateDropdown.click();
    }

    public void tapSignUpButton() {
        signUpButton.click();
    }

    public String getAffiliateErrorText() {
        return affiliateErrorMessage.getText();
    }

    public void selectAffiliateOption(String affiliateOption) {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+affiliateOption+"\"]")).click();
    }

    public String getAffiliateText() {
        return affiliateDropdown.getText();
    }

    public String getFirstNameErrorText() {
        return firstNameErrorMessage.getText();
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public String getFirstNameText() {
        return firstNameField.getText();
    }

    public String getLastNameErrorText() {
        return lastNameErrorMessage.getText();
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public String getLastNameText() {
        return lastNameField.getText();
    }

    public String getEmptyEmailErrorText() {
        return emptyEmailAddressErrorMessage.getText();
    }

    public String getInvalidEmailErrorText() {
        return invalidEmailAddressErrorMessage.getText();
    }

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
    }

    public String getEmailAddressText() {
        return emailAddressField.getText();
    }

    public String getEmptyPasswordErrorText() {
        return emptyPasswordErrorMessage.getText();
    }

    public String getInvalidPasswordErrorText() {
        return invalidPasswordErrorMessage.getText();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getPasswordText() {
        return passwordField.getText();
    }

    public void revealPassword() {
        passwordCheckIcon.click();
    }

    public @Nullable String verifyPasswordReveal() {
        return passwordField.getAttribute("password");
    }

    public String getEmptyRepeatPasswordErrorText() {
        return emptyRepeatPasswordErrorMessage.getText();
    }

    public String getInvalidRepeatPasswordErrorText() {
        return invalidRepeatPasswordErrorMessage.getText();
    }

    public String getRepeatPasswordNotMatchErrorText() {
        return repeatPasswordNotMatchErrorMessage.getText();
    }

    public void enterRepeatPassword(String repeatPassword) {
        repeatPasswordField.sendKeys(repeatPassword);
    }

    public String getRepeatPasswordText() {
        return repeatPasswordField.getText();
    }

    public void revealRepeatPassword() {
        repeatPasswordCheckIcon.click();
    }

    public @Nullable String verifyRepeatPasswordReveal() {
        return repeatPasswordField.getAttribute("password");
    }

    public String getSignUpMessageText() {
        return signUpErrorMessage.getText();
    }

    public void tapDoneButton() {
        doneButton.click();
    }

    public void clearFirstName() {
        firstNameField.clear();
    }

    public void clearLastName() {
        lastNameField.clear();
    }

    public void clearEmailAddress() {
        emailAddressField.clear();
    }

    public void clearPassword() {
        passwordField.clear();
    }

    public void clearRepeatPassword() {
        repeatPasswordField.clear();
    }
}
