package projects.seventh_topic.local.saucelabs.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class AndroidProductListPage extends ProductListPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement topMainMenuBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-Toggle")
    private ExtendedWebElement toggle;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\"]")
    private List<ExtendedWebElement> displayedProductTitles;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private List<ExtendedWebElement> displayedPrices;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])/android.view.ViewGroup/android.widget.ImageView")
    private List<ExtendedWebElement> displayedProductPics;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement filterBtn;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cart;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]//android.widget.TextView")
    private ExtendedWebElement cartProductCnt;

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADD TO CART\" or @text=\"REMOVE\"]")
    private List<ExtendedWebElement> addToCartBtnList;

    public AndroidProductListPage(WebDriver driver) {
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
        return title.getText();
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
        ExtendedWebElement lastItem = null;
        for (ExtendedWebElement item: displayedPrices) {
            String price = item.getText().substring(1);
            productPrices.add(Float.valueOf(price));
            lastItem = item;
        }
        while (lastItem.isElementPresent()) {
            swipeUp(1000);
        }
        displayedPrices = getDisplayedPrices();
        for (ExtendedWebElement item: displayedPrices) {
            String price = item.getText().substring(1);
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
        ExtendedWebElement lastItem = null;
        for (ExtendedWebElement item: displayedProductPics) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductDetailsPageBase.class);
            }
            lastItem = item;
            i++;
        }
        while (lastItem.isElementPresent()) {
            swipeUp(1000);
        }
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
        ExtendedWebElement lastItem = null;
        for (ExtendedWebElement item: addToCartBtnList) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductListPageBase.class);
            }
            lastItem = item;
            i++;
        }
        while (lastItem.isElementPresent()) {
            swipeUp(1000);
        }
        for (ExtendedWebElement item: addToCartBtnList) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductListPageBase.class);
            }
            lastItem = item;
            i++;
        }
        while (lastItem.isElementPresent()) {
            swipeUp(1000);
        }
        for (ExtendedWebElement item: addToCartBtnList) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductListPageBase.class);
            }
        }
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public ProductListPageBase removeProductFromCart(int n) {
        int i = 1;
        ExtendedWebElement lastItem = null;
        for (ExtendedWebElement item: addToCartBtnList) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductListPageBase.class);
            }
            lastItem = item;
            i++;
        }
        while (lastItem.isElementPresent()) {
            swipeUp(1000);
        }
        for (ExtendedWebElement item: addToCartBtnList) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductListPageBase.class);
            }
            lastItem = item;
            i++;
        }
        while (lastItem.isElementPresent()) {
            swipeUp(1000);
        }
        for (ExtendedWebElement item: addToCartBtnList) {
            if (i == n) {
                item.click();
                return initPage(getDriver(), ProductListPageBase.class);
            }
        }
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public int getCartProductCnt() {
        return Integer.valueOf(cartProductCnt.getText());
    }

    @Override
    public CartPageBase clickCartBtn() {
        cart.click();
        return initPage(getDriver(), CartPageBase.class);
    }
}
