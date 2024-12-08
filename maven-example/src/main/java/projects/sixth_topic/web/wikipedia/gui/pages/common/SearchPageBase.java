package projects.sixth_topic.web.wikipedia.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import projects.sixth_topic.web.wikipedia.gui.pages.android.*;

public abstract class SearchPageBase extends AbstractPage implements IMobileUtils {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AndroidSearchResultPage search(String keyword);
}
