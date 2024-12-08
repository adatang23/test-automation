package projects.sixth_topic.web.wikipedia.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.sixth_topic.web.wikipedia.gui.pages.common.SearchPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class AndroidSearchPage extends SearchPageBase {

    @FindBy(xpath = "//form[@class='search-box']/input[@name='search']")
    private ExtendedWebElement searchBar;

    public AndroidSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AndroidSearchResultPage search(String keyword) {
        searchBar.type(keyword);
        searchBar.sendKeys(Keys.ENTER);
        return new AndroidSearchResultPage(getDriver());
    }
}
