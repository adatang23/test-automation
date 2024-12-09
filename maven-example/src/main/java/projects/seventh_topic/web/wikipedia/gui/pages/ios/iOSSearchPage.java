package projects.seventh_topic.web.wikipedia.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.web.wikipedia.gui.pages.common.*;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchPageBase.class)
public class iOSSearchPage extends SearchPageBase {

    @FindBy(xpath = "//input[@name='search']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//span[@class='oo-ui-actionFieldLayout-button']")
    private ExtendedWebElement returnBtn;

    public iOSSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultPageBase search(String keyword) {
        searchBar.type(keyword);
        returnBtn.click();
        return initPage(getDriver(), SearchResultPageBase.class);
    }

    @Override
    public boolean isSearchbarPresent() {
        return searchBar.isElementPresent();
    }

    @Override
    public boolean isReturnBtnPresent() {
        return returnBtn.isElementPresent();
    }
}
