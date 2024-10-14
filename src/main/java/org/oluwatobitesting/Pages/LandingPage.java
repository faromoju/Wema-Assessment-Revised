package org.oluwatobitesting.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.oluwatobitesting.Utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends AndroidActions {
    //Declare AndroidDriver
    AndroidDriver driver;

    //Create Constructor of landingPage Class
    public LandingPage(AndroidDriver driver) {
        //Pass driver to parent class
        super(driver);

        //Set driver object from wherever class object is called
        this.driver = driver;

        //Driver Locators Constructor Method
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Locators
    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/landingPageIcon")
    public List<WebElement> landingPageIcon;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/loginBtn")
    private WebElement logInButton;

    @AndroidFindBy(id = "com.wemabank.alat.office.alat_qa_test:id/gettingStartedBtn")
    private WebElement getStartedButton;

    //Actions
    public void tapLogInButton() {
        logInButton.click();
    }

    public void tapGetStartedButton() {
        getStartedButton.click();
    }
}
