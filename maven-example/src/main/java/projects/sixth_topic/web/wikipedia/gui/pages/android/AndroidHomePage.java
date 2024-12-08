package projects.sixth_topic.web.wikipedia.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.sixth_topic.web.wikipedia.gui.pages.common.HomePageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class AndroidHomePage extends HomePageBase {

    @FindBy(xpath = "//header[contains(@class, 'header-container')]")
    private ExtendedWebElement header;

    @FindBy(id = "searchIcon")
    private ExtendedWebElement searchBarBtn;


    public AndroidHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHeaderPresent() {
        return header.isElementPresent();
    }

    @Override
    public boolean isSearchBarBtnPresent() {
        return searchBarBtn.isElementPresent();
    }

    @Override
    public AndroidSearchPage clickSearchBarBtn() {
        searchBarBtn.click();
        return new AndroidSearchPage(getDriver());
    }
}
