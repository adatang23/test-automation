package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.desktop.*;
import projects.fifth_topic.enums.*;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//a[@class='logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//a[contains(text(), 'Sign In')]")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//a[contains(@href, '/create')]")
    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = "//span[contains(@class, 'logged-in')]")
    private ExtendedWebElement userName;

    @FindBy(xpath = "//a[@href='%s']")
    private ExtendedWebElement headerItem;

    @FindBy(xpath = "//button[@class='action switch']")
    private ExtendedWebElement actionSwitchButton;

    @FindBy(xpath = "//a[contains(text(), 'Sign Out')]")
    private ExtendedWebElement signOutHyperLink;

    @FindBy(id = "ui-id-3")
    private ExtendedWebElement whatsNewButton;

    @FindBy(id = "ui-id-4")
    private ExtendedWebElement womenButton;

    @FindBy(id = "ui-id-5")
    private ExtendedWebElement menButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage(getDriver());
    }

    public CreateAccountPage clickCreateAccountButton() {
        createAccountButton.click();
        return new CreateAccountPage(getDriver());
    }

    public WhatsNewPage clickWhatsNewButton() {
        whatsNewButton.click();
        return new WhatsNewPage(getDriver());
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

    public void actionSwitchButtonClick() {
        actionSwitchButton.click();
    }

    public HomePage signOut() {
        signOutHyperLink.click();
        return new HomePage(getDriver());
    }

    public AbstractPage pickHeaderMenuItem(HeaderMenuItems item) {
        switch(item) {
            case SIGNIN_PAGE:
                headerItem.format(item.getHref());
                headerItem.click();
                return new SignInPage(getDriver());
            case CREATE_ACCOUNT_PAGE:
                headerItem.format(item.getHref());
                headerItem.click();
                return new CreateAccountPage(getDriver());
            default:
                throw new NotImplementedException("Href " + item.getHref() + " not implemented");
        }
    }
}
