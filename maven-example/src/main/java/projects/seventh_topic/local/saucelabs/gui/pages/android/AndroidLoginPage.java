package projects.seventh_topic.local.saucelabs.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;
import static projects.seventh_topic.local.saucelabs.constants.ProjectConstants.*;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class AndroidLoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Login\"]//android.widget.ImageView[1]")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameInputField;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordInputField;

    @FindBy(xpath = "//android.widget.TextView[@text=\"standard_user\"]")
    private ExtendedWebElement standardUser;

    @FindBy(xpath = "//android.widget.TextView[@text=\"locked_out_user\"]")
    private ExtendedWebElement lockedOutUser;

    @FindBy(xpath = "//android.widget.TextView[@text=\"problem_user\"]")
    private ExtendedWebElement problemUser;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    public AndroidLoginPage(WebDriver driver) {
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
