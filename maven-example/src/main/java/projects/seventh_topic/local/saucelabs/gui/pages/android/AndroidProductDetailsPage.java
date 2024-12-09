package projects.seventh_topic.local.saucelabs.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPageBase.class)
public class AndroidProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"BACK TO PRODUCTS\"]")
    private ExtendedWebElement backToProductsBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    private ExtendedWebElement description;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADD TO CART\"]")
    private ExtendedWebElement addToCartBtn;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cart;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]//android.widget.TextView")
    private ExtendedWebElement cartProductCnt;


    public AndroidProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductListPageBase clickBackToProductBtn() {
        backToProductsBtn.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public String getProductName() {
        return name.getText();
    }

    @Override
    public String getDescription() {
        return description.getText();
    }

    @Override
    public Float getPrice() {
        while (!price.isElementPresent()) {
            swipeUp(1000);
        }
        String priceStr = price.getText().substring(1).trim();
        return Float.valueOf(priceStr);
    }

    @Override
    public ProductDetailsPageBase clickAddToCartBtn() {
        while (!addToCartBtn.isElementPresent()) {
            swipeUp(1000);
        }
        addToCartBtn.click();
        return initPage(getDriver(), ProductDetailsPageBase.class);
    }
}
