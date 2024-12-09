package projects.seventh_topic.local.saucelabs.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterPageBase.class)
public class AndroidFilterPage extends FilterPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Name (A to Z)\"]")
    private ExtendedWebElement sortByName;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Name (Z to A)\"]")
    private ExtendedWebElement reverseSortByName;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
    private ExtendedWebElement sortByPrice;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Price (high to low)\"]")
    private ExtendedWebElement reverseSortByPrice;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Cancel\"]")
    private ExtendedWebElement cancel;

    public AndroidFilterPage(WebDriver driver) {
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
