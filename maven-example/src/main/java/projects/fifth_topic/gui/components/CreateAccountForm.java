package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.desktop.HomePage;

public class CreateAccountForm extends AbstractUIObject {

    @FindBy(xpath = "//span[@class='base']")
    private ExtendedWebElement createAccountTitle;

    @FindBy(xpath = "//input[@id='firstname']")
    private ExtendedWebElement createAccountFirstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private ExtendedWebElement createAccountLastNameField;

    @FindBy(xpath = "//input[@id='email_address']")
    private ExtendedWebElement createAccountEmailField;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement createAccountPasswordField;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private ExtendedWebElement createAccountConfirmPasswordField;

    @FindBy(xpath = "//span[@id='password-strength-meter-label']")
    private ExtendedWebElement createAccountPasswordStrengthMsg;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = "//div[@id='firstname-error']")
    private ExtendedWebElement firstNameErrorMsg;

    @FindBy(xpath = "//div[@id='lastname-error']")
    private ExtendedWebElement lastNameErrorMsg;

    @FindBy(xpath = "//div[@id='email_address-error']")
    private ExtendedWebElement emailErrorMsg;

    @FindBy(xpath = "//div[@id='password-error']")
    private ExtendedWebElement passwordErrorMsg;

    @FindBy(xpath = "//div[@id='password-confirmation-error']")
    private ExtendedWebElement confirmPasswordErrorMsg;

    public CreateAccountForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isCreateAccountTitlePresent() {
        return createAccountTitle.isDisplayed();
    }

    public String getCreateAccountTitleText(String formTitle) {
        createAccountTitle.format(formTitle);
        return createAccountTitle.getText();
    }

    public void inputCreateAccountFirstName(String firstName) {
        if (isCreateAccountEmailPresent()) {
            createAccountEmailField.type(firstName);
        }
    }

    public boolean isCreateAccountFirstNamePresent() {
        return createAccountFirstNameField.isDisplayed();
    }

    public void inputCreateAccountLastName(String lastName) {
        if (isCreateAccountLastNamePresent()) {
            createAccountLastNameField.type(lastName);
        }
    }

    public boolean isCreateAccountLastNamePresent() {
        return createAccountLastNameField.isDisplayed();
    }

    public void inputCreateAccountEmail(String email) {
        if (isCreateAccountEmailPresent()) {
            createAccountEmailField.type(email);
        }
    }

    public boolean isCreateAccountEmailPresent() {
        return createAccountEmailField.isDisplayed();
    }

    public void inputCreateAccountPassword(String password) {
        if (isCreateAccountPasswordPresent()) {
            createAccountPasswordField.type(password);
        }
    }

    public boolean isCreateAccountPasswordPresent() {
        return createAccountPasswordField.isDisplayed();
    }

    public void inputCreateAccountConfirmPassword(String confirmPassword) {
        if (isCreateAccountConfirmPasswordPresent()) {
            createAccountConfirmPasswordField.type(confirmPassword);
        }
    }

    public boolean isCreateAccountConfirmPasswordPresent() {
        return createAccountConfirmPasswordField.isDisplayed();
    }

    public String getPasswordStrength() {
        return createAccountPasswordStrengthMsg.getText();
    }

    public String getCreateAccountFirstNameErrorMsg() {
        return firstNameErrorMsg.getText();
    }

    public String getCreateAccountLastNameErrorMsg() {
        return lastNameErrorMsg.getText();
    }

    public String getCreateAccountEmailErrorMsg() {
        return emailErrorMsg.getText();
    }

    public String getCreateAccountPasswordErrorMsg() {
        return passwordErrorMsg.getText();
    }

    public String getCreateAccountConfirmPasswordErrorMsg() {
        return confirmPasswordErrorMsg.getText();
    }

    public boolean isCreateAccountFirstNameErrorMsgPresent() {
        return firstNameErrorMsg.isDisplayed();
    }

    public boolean isCreateAccountLastNameErrorMsgPresent() {
        return lastNameErrorMsg.isDisplayed();
    }

    public boolean isCreateAccountEmailErrorMsgPresent() {
        return emailErrorMsg.isDisplayed();
    }

    public boolean isCreateAccountPasswordErrorMsgPresent() {
        return passwordErrorMsg.isDisplayed();
    }

    public boolean isCreateAccountConfirmPasswordErrorMsgPresent() {
        return confirmPasswordErrorMsg.isDisplayed();
    }

    public HomePage createAccountButtonClick() {
        createAccountButton.click();
        return new HomePage(getDriver());
    }
}
