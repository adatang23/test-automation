package projects.sixth_topic.local.saucelabs.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage implements IMobileUtils {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract ProductListPageBase selectValidUser();

    public abstract ProductListPageBase selectUser(String user);

    public abstract ProductListPageBase login(String username, String password);

    public abstract ProductListPageBase quickLogin();
}
