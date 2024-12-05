package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.desktop.*;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//a[@class='logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//a[contains(text(), 'Sign In')]")
    private ExtendedWebElement signInLink;

    @FindBy(xpath = "//a[contains(@href, '/create')]")
    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = "//span[contains(@class, 'logged-in')]")
    private ExtendedWebElement userName;

    @FindBy(id = "search")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@class='minicart-wrapper']/a[@class='action showcart']")
    private ExtendedWebElement cart;

    @FindBy(xpath = "//button[@class='action switch']")
    private ExtendedWebElement actionSwitchButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign Out')]")
    private ExtendedWebElement signOutHyperLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SignInPage clickSignInLink() {
        signInLink.click();
        return new SignInPage(getDriver());
    }

    public CreateAccountPage clickCreateAccountButton() {
        createAccountButton.click();
        return new CreateAccountPage(getDriver());
    }

    public String getUserName() {
        return userName.getText();
    }

    public boolean isActionSwitchButtonPresent() {
        return actionSwitchButton.isDisplayed();
    }

    public boolean isSignOutHyperLinkPresent() {
        return signOutHyperLink.isDisplayed();
    }

    public boolean isLogoPresent() {
        return logo.isDisplayed();
    }

    public HomePage clickLogo() {
        logo.click();
        return new HomePage(getDriver());
    }

    public void actionSwitchButtonClick() {
        actionSwitchButton.click();
    }

    public HomePage signOut() {
        signOutHyperLink.click();
        return new HomePage(getDriver());
    }
}
