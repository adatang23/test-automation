package projects.seventh_topic.web.wikipedia.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import projects.seventh_topic.web.wikipedia.gui.pages.android.AndroidSearchResultPage;

public abstract class SearchPageBase extends AbstractPage implements IMobileUtils {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchResultPageBase search(String keyword);

    public abstract boolean isSearchbarPresent();

    public abstract boolean isReturnBtnPresent();
}
