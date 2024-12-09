package projects.seventh_topic.web.wikipedia.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.web.wikipedia.gui.pages.common.*;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class iOSHomePage extends HomePageBase {

    @FindBy(xpath = "//h1[@class='central-textlogo-wrapper']/span")
    private ExtendedWebElement header;

    @FindBy(id = "searchInput")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement searchBarBtn;


    public iOSHomePage(WebDriver driver) {
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
