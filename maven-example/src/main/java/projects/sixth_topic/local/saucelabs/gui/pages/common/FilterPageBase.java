package projects.sixth_topic.local.saucelabs.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FilterPageBase extends AbstractPage implements IMobileUtils {

    public FilterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListPageBase sortByName();

    public abstract ProductListPageBase reverseSortByName();

    public abstract ProductListPageBase sortByPrice();

    public abstract ProductListPageBase reverseSortByPrice();
}
