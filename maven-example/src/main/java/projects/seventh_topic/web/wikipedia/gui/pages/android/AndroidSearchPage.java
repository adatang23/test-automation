package projects.seventh_topic.web.wikipedia.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.web.wikipedia.gui.pages.common.SearchPageBase;
import projects.seventh_topic.web.wikipedia.gui.pages.common.SearchResultPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class AndroidSearchPage extends SearchPageBase {

    @FindBy(xpath = "//input[@name='search']")
    private ExtendedWebElement searchBar;

    public AndroidSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultPageBase search(String keyword) {
        searchBar.type(keyword);
        searchBar.sendKeys(Keys.ENTER);
        return initPage(getDriver(), SearchResultPageBase.class);
    }

    @Override
    public boolean isSearchbarPresent() {
        return false;
    }

    @Override
    public boolean isReturnBtnPresent() {
        return false;
    }
}
