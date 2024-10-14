package org.oluwatobitesting.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.oluwatobitesting.Utils.AndroidActions;
import org.oluwatobitesting.Utils.AppiumUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GetStartedPage extends AndroidActions {
    //Declare AndroidDriver
    AndroidDriver driver;

    //Class Constructor
    public GetStartedPage(AndroidDriver driver) {
        super(driver);

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Locators
    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/textView2")
    public List<WebElement> welcomeTitle;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/affiliateSignUpBtn")
    private WebElement affiliateSignUpButton;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/staffSignUpBtn")
    private WebElement staffSignUpButton;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/continueButton")
    private WebElement continueButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement backButton;

    //Actions
    public void tapSignUpAsAffiliate() {
        affiliateSignUpButton.click();
    }

    public void tapSignUpAsStaff() {
        staffSignUpButton.click();
    }

    public void tapContinueButton() {
        continueButton.click();
    }

    public void tapBackButton() {
        backButton.click();
    }
}
