package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.desktop.*;

public class SignInForm extends AbstractUIObject {

    @FindBy(xpath = "//strong[@id='block-customer-login-heading']")
    private ExtendedWebElement signInFormTitle;

    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement emailSignInField;

    @FindBy(xpath = "//input[@id='pass']")
    private ExtendedWebElement passwordSignInField;

    @FindBy(xpath = "//button[@id='send2']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//div[@class='primary']")
    private ExtendedWebElement switchCreateAccountButton;

    @FindBy(xpath = "//div[@id='email-error']")
    private ExtendedWebElement emailErrorMsg;

    @FindBy(xpath = "//div[@id='pass-error']")
    private ExtendedWebElement passwordErrorMsg;


    public SignInForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isSignInEmailPresent() {
        return emailSignInField.isDisplayed();
    }

    public boolean isSignInPasswordPresent() {
        return passwordSignInField.isDisplayed();
    }

    public boolean isSignInButtonPresent() {
        return signInButton.isDisplayed();
    }

    public boolean isEmailErrorMsgPresent() {
        return emailErrorMsg.isDisplayed();
    }

    public boolean isPasswordErrorMsgPresent() {
        return passwordErrorMsg.isDisplayed();
    }

    public String getEmailErrorMsgText() {
        return emailErrorMsg.getText();
    }

    public String getPasswordErrorMsgText() {
        return passwordErrorMsg.getText();
    }

    public void signInButtonClickError() {
        signInButton.click();
    }

    public void inputSignInEmail(String email) {
        emailSignInField.type(email);
    }

    public void inputSignInPassword(String password) {
        passwordSignInField.type(password);
    }

    public HomePage signInButtonClick() {
        signInButton.click();
        return new HomePage(getDriver());
    }

    public CreateAccountPage switchCreateAccountButtonClick() {
        switchCreateAccountButton.click();
        return new CreateAccountPage(getDriver());
    }

    public boolean isSignInFormTitlePresent() {
        return signInFormTitle.isDisplayed();
    }

    public String getSignInFormTitle(String formTitle) {
        signInFormTitle.format(formTitle);
        return signInFormTitle.getText();
    }

    public HomePage signIn(String email, String password) {
        inputSignInEmail(email);
        inputSignInPassword(password);
        return signInButtonClick();
    }
}
