package projects.seventh_topic.local.saucelabs.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends AbstractPage implements IMobileUtils {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitle();
}
