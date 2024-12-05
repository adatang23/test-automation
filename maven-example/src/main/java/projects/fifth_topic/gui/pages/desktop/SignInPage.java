package projects.fifth_topic.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.common.BaseSitePage;


public class SignInPage extends BaseSitePage {

    @FindBy(xpath = "//h1[@class='page-title']/span")
    private ExtendedWebElement title;

    @FindBy(id = "email")
    private ExtendedWebElement emailBlank;

    @FindBy(id = "pass")
    private ExtendedWebElement passwordBlank;

    @FindBy(id = "send2")
    private ExtendedWebElement signInButton;

    @FindBy(id = "email-error")
    private ExtendedWebElement emailErrorMsg;

    @FindBy(id = "pass-error")
    private ExtendedWebElement passwordErrorMsg;

    @FindBy(xpath = "//div[@data-ui-id='message-error']/div")
    private ExtendedWebElement signInErrorMsg;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return title.isDisplayed();
    }

    public String getTitle() {
        return title.getAttribute("innerHTML");
    }

    public boolean isEmailBlankPresent() {
        return emailBlank.isDisplayed();
    }

    public boolean isPasswordBlankPresent() {
        return passwordBlank.isDisplayed();
    }

    public boolean isSignInButtonPresent() {
        return signInButton.isDisplayed();
    }

    public void inputEmailBlank(String email) {
        emailBlank.type(email);
    }

    public void inputPasswordBlank(String password) {
        passwordBlank.type(password);
    }

    public void clickMyAccountSignInButtonError() {
        signInButton.click();
    }

    public String getEmailErrorMsg() {
        if (isEmailErrorMsgPresent()) {
            return emailErrorMsg.getAttribute("innerHTML");
        }
        return null;
    }

    public boolean isEmailErrorMsgPresent() {
        return emailErrorMsg.isDisplayed();
    }

    public String getPasswordErrorMsg() {
        if (isPasswordErrorMsgPresent()) {
            return passwordErrorMsg.getAttribute("innerHTML");
        }
        return null;
    }

    public boolean isPasswordErrorMsgPresent() {
        return passwordErrorMsg.isDisplayed();
    }

    public String getSignInErrorMsg() {
        if (isSignInErrorMsgPresent()) {
            return signInErrorMsg.getAttribute("innerHTML").trim();
        }
        return null;
    }

    public boolean isSignInErrorMsgPresent() {
        return signInErrorMsg.isDisplayed();
    }

    public HomePage signIn(String email, String password) {
        inputEmailBlank(email);
        inputPasswordBlank(password);
        signInButton.click();
        return new HomePage(getDriver());
    }
}
