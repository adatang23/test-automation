package projects.seventh_topic.local.saucelabs.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;
import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductListPageBase.class)
public class iOSProductListPage extends ProductListPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
    private ExtendedWebElement topMainMenuBtn;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-Toggle")
    private ExtendedWebElement toggle;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"test-Item title\"]")
    private List<ExtendedWebElement> displayedProductTitles;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"test-Price\"]")
    private List<ExtendedWebElement> displayedPrices;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Item\"]//XCUIElementTypeImage")
    private List<ExtendedWebElement> displayedProductPics;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement filterBtn;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Cart\"]/XCUIElementTypeOther")
    private ExtendedWebElement cart;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartProductCnt;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-ADD TO CART\" or @name=\"test-REMOVE\"]")
    private List<ExtendedWebElement> addToCartBtnList;

    public iOSProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        try {
            if (title.isElementPresent()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TopMenuPageBase openTopMainMenu() {
        topMainMenuBtn.click();
        return initPage(getDriver(), TopMenuPageBase.class);
    }

    @Override
    public String getTitle() {
        return title.getAttribute("name");
    }

    @Override
    public ProductListPageBase clickToggle() {
        toggle.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public int countDisplayedProductTitles() {
        return displayedProductTitles.size();
    }

    @Override
    public FilterPageBase clickFilterBtn() {
        filterBtn.click();
        return initPage(getDriver(), FilterPageBase.class);
    }

    @Override
    public List<ExtendedWebElement> getDisplayedPrices() {
        return displayedPrices;
    }

    @Override
    public List<Float> getProductPrices() {
        List<Float> productPrices = new ArrayList<>();
        clickToggle();
        List<ExtendedWebElement> displayedPrices = getDisplayedPrices();
        for (ExtendedWebElement item: displayedPrices) {
            String price = item.getAttribute("value").substring(1);
            productPrices.add(Float.valueOf(price));
        }
        return productPrices;
    }

    @Override
    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        clickToggle();
        List<ExtendedWebElement> displayedTitles = displayedProductTitles;
        for (ExtendedWebElement item: displayedProductTitles) {
            String name = item.getAttribute("value");
            productNames.add(name);
        }
        return productNames;
    }

    @Override
    public ProductDetailsPageBase selectProductViewDetails(int n) {
        int i = 1;
        for (ExtendedWebElement item: displayedProductPics) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductDetailsPageBase.class);
            }
            i++;
        }
        return null;
    }

    @Override
    public ProductListPageBase selectProductToCart(int n) {
        int i = 1;
        for (ExtendedWebElement item: addToCartBtnList) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductListPageBase.class);
            }
            i++;
        }
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase removeProductFromCart(int n) {
        int i = 1;
        for (ExtendedWebElement item: addToCartBtnList) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductListPageBase.class);
            }
            i++;
        }
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public int getCartProductCnt() {
        return Integer.valueOf(cartProductCnt.getAttribute("label"));
    }

    @Override
    public CartPageBase clickCartBtn() {
        cart.click();
        return initPage(getDriver(), CartPageBase.class);
    }
}
