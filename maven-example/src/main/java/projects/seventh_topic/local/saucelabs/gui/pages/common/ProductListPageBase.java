package projects.seventh_topic.local.saucelabs.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListPageBase extends AbstractPage implements IMobileUtils {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract TopMenuPageBase openTopMainMenu();

    public abstract String getTitle();

    public abstract ProductListPageBase clickToggle();

    public abstract int countDisplayedProductTitles();

    public abstract FilterPageBase clickFilterBtn();

    public abstract List<ExtendedWebElement> getDisplayedPrices();

    public abstract List<Float> getProductPrices();

    public abstract List<String> getProductNames();

    public abstract ProductDetailsPageBase selectProductViewDetails(int n);

    public abstract ProductListPageBase selectProductToCart(int n);

    public abstract ProductListPageBase removeProductFromCart(int n);

    public abstract int getCartProductCnt();

    public abstract CartPageBase clickCartBtn();
}
