package projects.seventh_topic.local.saucelabs.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;
import static projects.seventh_topic.local.saucelabs.constants.ProjectConstants.*;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class iOSLoginPage extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "assets/src/img/swag-labs-logo.png")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameInputField;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordInputField;

    @ExtendedFindBy(accessibilityId = "test-standard_user")
    private ExtendedWebElement standardUser;

    @ExtendedFindBy(accessibilityId = "test-locked_out_user")
    private ExtendedWebElement lockedOutUser;

    @ExtendedFindBy(accessibilityId = "test-problem_user")
    private ExtendedWebElement problemUser;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    public iOSLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public void typeUsername(String username) {
        usernameInputField.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public ProductListPageBase selectValidUser() {
        swipeUp(2000);
        standardUser.click();
        loginBtn.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase selectUser(String user) {
        swipeUp(2000);
        switch (user) {
            case STANDARD_USER:
                standardUser.click();
                loginBtn.click();
                return initPage(getDriver(), ProductListPageBase.class);
            case LOCKED_OUT_USER:
                lockedOutUser.click();
                loginBtn.click();
                return initPage(getDriver(), ProductListPageBase.class);
            case PROBLEM_USER:
                problemUser.click();
                loginBtn.click();
                return initPage(getDriver(), ProductListPageBase.class);
            default:
                return initPage(getDriver(), ProductListPageBase.class);
        }
    }

    @Override
    public ProductListPageBase login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        loginBtn.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase quickLogin() {
        typeUsername("standard_user");
        typePassword("secret_sauce");
        loginBtn.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }
}
