package projects.seventh_topic.local.saucelabs.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FilterPageBase.class)
public class iOSFilterPage extends FilterPageBase {

    @ExtendedFindBy(accessibilityId = "Name (A to Z)")
    private ExtendedWebElement sortByName;

    @ExtendedFindBy(accessibilityId = "Name (Z to A)")
    private ExtendedWebElement reverseSortByName;

    @ExtendedFindBy(accessibilityId = "Price (low to high)")
    private ExtendedWebElement sortByPrice;

    @ExtendedFindBy(accessibilityId = "Price (high to low)")
    private ExtendedWebElement reverseSortByPrice;

    @FindBy(xpath = "(//XCUIElementTypeOther[@name=\"Cancel\"])[2]")
    private ExtendedWebElement cancel;

    public iOSFilterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductListPageBase sortByName() {
        sortByName.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase reverseSortByName() {
        reverseSortByName.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase sortByPrice() {
        sortByPrice.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase reverseSortByPrice() {
        reverseSortByPrice.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }
}
