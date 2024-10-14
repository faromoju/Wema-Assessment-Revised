package org.oluwatobitesting.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jspecify.annotations.Nullable;
import org.oluwatobitesting.Utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LogInPage extends AndroidActions {
    //Declare AndroidDriver
    AndroidDriver driver;

    //Class Constructor
    public LogInPage(AndroidDriver driver) {
        super(driver);

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Locators
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Welcome Back!\"]")
    public List<WebElement> welcomeBackTitle;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/email_input")
    private WebElement emailAddressField;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/password_input")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Show password")
    private WebElement passwordToggle;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/loginBtn")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Email' must not be empty.\"]")
    private WebElement noEmailError;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Email' is not a valid email address.\"]")
    private WebElement invalidEmailError;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"'Password' must not be empty.\"]")
    private WebElement noPasswordError;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/status_text")
    public List<WebElement> logInError;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/status_btn_text")
    private WebElement doneButton;

    public String errorPopUpTextId = "com.wemabank.alat.office.alat_qa_test:id/status_text";

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement pageBackButton;

    //Actions
    public void inputEmailAddress(String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
        driver.hideKeyboard();
    }

    public String emailAddressValue() {
        return emailAddressField.getText();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
        driver.hideKeyboard();
    }

    public String passwordValue() {
        return passwordField.getText();
    }

    public void tapPasswordToggle() {
        passwordToggle.click();
    }

    public @Nullable String passwordStatus() {
        return passwordField.getAttribute("password");
    }

    public void tapLoginButton() {
        loginButton.click();
    }

    public String noEmailErrorText() {
        return noEmailError.getAttribute("text");
    }

    public String invalidEmailErrorText() {
        return invalidEmailError.getAttribute("text");
    }

    public String noPasswordErrorText() {
        return noPasswordError.getAttribute("text");
    }

    public String logInErrorText() {
        return logInError.get(0).getText();
    }

    public void tapDoneButton() {
        doneButton.click();
    }

    public void tapPageBackButton() {
        pageBackButton.click();
    }

    public void clearEmailAddress() {
        emailAddressField.clear();
    }

    public void clearPassword() {
        passwordField.clear();
    }
}
