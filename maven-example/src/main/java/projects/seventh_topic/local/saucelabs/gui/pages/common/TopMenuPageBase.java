package projects.seventh_topic.local.saucelabs.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TopMenuPageBase extends AbstractPage implements IMobileUtils {

    public TopMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTopMainMenuOpen();

    public abstract void closeTopMainMenu();

    public abstract ProductListPageBase selectAllItems();

    public abstract WebViewPageBase selectWebView();

    public abstract DrawingPageBase selectDrawing();

    public abstract LoginPageBase selectLogout();
}
