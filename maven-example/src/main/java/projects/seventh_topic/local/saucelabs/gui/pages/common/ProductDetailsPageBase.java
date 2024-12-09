package projects.seventh_topic.local.saucelabs.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsPageBase extends AbstractPage implements IMobileUtils {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListPageBase clickBackToProductBtn();

    public abstract String getProductName();

    public abstract String getDescription();

    public abstract Float getPrice();

    public abstract ProductDetailsPageBase clickAddToCartBtn();
}
