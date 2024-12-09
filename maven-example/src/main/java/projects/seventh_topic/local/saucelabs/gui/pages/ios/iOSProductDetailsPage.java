package projects.seventh_topic.local.saucelabs.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailsPageBase.class)
public class iOSProductDetailsPage extends ProductDetailsPageBase {

    @ExtendedFindBy(accessibilityId = "test-BACK TO PRODUCTS")
    private ExtendedWebElement backToProductsBtn;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Description']/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Description']/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement description;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Cart\"]/XCUIElementTypeOther")
    private ExtendedWebElement cart;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Cart\"]/XCUIElementTypeOther")
    private ExtendedWebElement cartProductCnt;

    public iOSProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductListPageBase clickBackToProductBtn() {
        backToProductsBtn.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public String getProductName() {
        return name.getAttribute("value");
    }

    @Override
    public String getDescription() {
        return description.getAttribute("value");
    }

    @Override
    public Float getPrice() {
        String priceStr = price.getAttribute("value").substring(1).trim();
        return Float.valueOf(priceStr);
    }

    @Override
    public ProductDetailsPageBase clickAddToCartBtn() {
        addToCartBtn.click();
        return initPage(getDriver(), ProductDetailsPageBase.class);
    }
}
