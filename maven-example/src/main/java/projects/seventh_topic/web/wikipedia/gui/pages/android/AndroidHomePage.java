package projects.seventh_topic.web.wikipedia.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.web.wikipedia.gui.pages.common.HomePageBase;
import projects.seventh_topic.web.wikipedia.gui.pages.common.SearchPageBase;
import projects.seventh_topic.web.wikipedia.gui.pages.common.SearchResultPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class AndroidHomePage extends HomePageBase {

    @FindBy(xpath = "//h1[@class='central-textlogo-wrapper']/span")
    private ExtendedWebElement header;

    @FindBy(xpath = "//button[@type='submit']")
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
    public SearchPageBase clickSearchBarBtn() {
        searchBarBtn.click();
        return initPage(getDriver(), SearchPageBase.class);
    }
}
