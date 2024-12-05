package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.desktop.HomePage;

public class CreateAccountForm extends AbstractUIObject {

    @FindBy(xpath = "//span[@class='base']")
    private ExtendedWebElement title;

    @FindBy(id = "firstname")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "lastname")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "email_address")
    private ExtendedWebElement emailField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "password-confirmation")
    private ExtendedWebElement confirmPasswordField;

    @FindBy(id = "password-strength-meter-label")
    private ExtendedWebElement passwordStrengthMsg;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private ExtendedWebElement createAccountButton;

    @FindBy(id = "firstname-error")
    private ExtendedWebElement firstNameErrorMsg;

    @FindBy(id = "lastname-error")
    private ExtendedWebElement lastNameErrorMsg;

    @FindBy(id = "email_address-error")
    private ExtendedWebElement emailErrorMsg;

    @FindBy(id = "password-error")
    private ExtendedWebElement passwordErrorMsg;

    @FindBy(id = "password-confirmation-error")
    private ExtendedWebElement confirmPasswordErrorMsg;

    public CreateAccountForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isTitlePresent() {
        return title.isDisplayed();
    }

    public String getTitleText(String formTitle) {
        title.format(formTitle);
        return title.getText();
    }

    public void inputFirstName(String firstName) {
        if (isEmailPresent()) {
            emailField.type(firstName);
        }
    }

    public boolean isFirstNamePresent() {
        return firstNameField.isDisplayed();
    }

    public void inputLastName(String lastName) {
        if (isLastNamePresent()) {
            lastNameField.type(lastName);
        }
    }

    public boolean isLastNamePresent() {
        return lastNameField.isDisplayed();
    }

    public void inputEmail(String email) {
        if (isEmailPresent()) {
            emailField.type(email);
        }
    }

    public boolean isEmailPresent() {
        return emailField.isDisplayed();
    }

    public void inputPassword(String password) {
        if (isPasswordPresent()) {
            passwordField.type(password);
        }
    }

    public boolean isPasswordPresent() {
        return passwordField.isDisplayed();
    }

    public void inputConfirmPassword(String confirmPassword) {
        if (isConfirmPasswordPresent()) {
            confirmPasswordField.type(confirmPassword);
        }
    }

    public boolean isConfirmPasswordPresent() {
        return confirmPasswordField.isDisplayed();
    }

    public String getPasswordStrength() {
        return passwordStrengthMsg.getText();
    }

    public String getFirstNameErrorMsg() {
        return firstNameErrorMsg.getText();
    }

    public String getLastNameErrorMsg() {
        return lastNameErrorMsg.getText();
    }

    public String getEmailErrorMsg() {
        return emailErrorMsg.getText();
    }

    public String getPasswordErrorMsg() {
        return passwordErrorMsg.getText();
    }

    public String getConfirmPasswordErrorMsg() {
        return confirmPasswordErrorMsg.getText();
    }

    public boolean isFirstNameErrorMsgPresent() {
        return firstNameErrorMsg.isDisplayed();
    }

    public boolean isLastNameErrorMsgPresent() {
        return lastNameErrorMsg.isDisplayed();
    }

    public boolean isEmailErrorMsgPresent() {
        return emailErrorMsg.isDisplayed();
    }

    public boolean isPasswordErrorMsgPresent() {
        return passwordErrorMsg.isDisplayed();
    }

    public boolean isConfirmPasswordErrorMsgPresent() {
        return confirmPasswordErrorMsg.isDisplayed();
    }

    public HomePage createAccountButtonClick() {
        createAccountButton.click();
        return new HomePage(getDriver());
    }
}
