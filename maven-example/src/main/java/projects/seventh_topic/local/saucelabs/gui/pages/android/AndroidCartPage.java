package projects.seventh_topic.local.saucelabs.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.CartPageBase;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class AndroidCartPage extends CartPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"YOUR CART\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]")
    private List<ExtendedWebElement> productItemList;


    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
    private ExtendedWebElement removeBtn;

    public AndroidCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    @Override
    public String getAllProductNamePrice() {
        String res = "{ ";
        for (ExtendedWebElement item: productItemList) {
            while (!removeBtn.isElementPresent()) {
                swipeUp(2000);
            }
            String productName = name.getText();
            String productPrice = price.getText();
            res += productName + ":";
            res += productPrice + ", ";
        }
        res += "}";
        return res;
    }
}
