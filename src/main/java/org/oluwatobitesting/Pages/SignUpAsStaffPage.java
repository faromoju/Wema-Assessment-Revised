package org.oluwatobitesting.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.oluwatobitesting.Utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignUpAsStaffPage extends AndroidActions {
    //Declare AndroidDriver
    AndroidDriver driver;

    public SignUpAsStaffPage(AndroidDriver driver) {
        super(driver);

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Locators
    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/staffIdEditText")
    private WebElement staffIdField;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/verifyButton")
    private WebElement verifyStaffIdButton;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/textinput_error")
    private WebElement emptyStaffIdError;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/status_text")
    private WebElement staffIdNotFoundError;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/status_btn_text")
    private WebElement doneButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement backButton;

    //Actions
    public void enterStaffID(String staffId) {
        staffIdField.sendKeys(staffId);
    }

    public String getStaffIDText() {
        return staffIdField.getText();
    }

    public void tapVerifyStaffIDButton() {
        verifyStaffIdButton.click();
    }

    public String getStaffIDErrorText() {
        return emptyStaffIdError.getText();
    }

    public String getStaffIDNotFoundErrorText() {
        return staffIdNotFoundError.getText();
    }

    public void tapDoneButton() {
        doneButton.click();
    }

    public void tapBackButton() {
        backButton.click();
    }

    public void clearStaffID() {
        staffIdField.clear();
    }
}
