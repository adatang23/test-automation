package projects.seventh_topic.web.wikipedia.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import projects.seventh_topic.web.wikipedia.gui.pages.android.AndroidSearchPage;

public abstract class HomePageBase extends AbstractPage implements IMobileUtils {

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://www.wikipedia.org");
    }

    public abstract boolean isHeaderPresent();

    public abstract boolean isSearchBarBtnPresent();

    public abstract SearchPageBase clickSearchBarBtn();

}
