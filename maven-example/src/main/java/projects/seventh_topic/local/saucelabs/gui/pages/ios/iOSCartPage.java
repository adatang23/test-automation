package projects.seventh_topic.local.saucelabs.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.CartPageBase;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class iOSCartPage extends CartPageBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"YOUR CART\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Item\"]")
    private List<ExtendedWebElement> productItemList;


    @FindBy(xpath = ".//XCUIElementTypeOther[@name=\"test-Description\"]/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = ".//XCUIElementTypeOther[@name=\"test-Price\"]/XCUIElementTypeStaticText")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//XCUIElementTypeOther[@name=\"test-REMOVE\"]")
    private ExtendedWebElement removeBtn;

    public iOSCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return title.getAttribute("name");
    }

    @Override
    public String getAllProductNamePrice() {
        String res = "{ ";
        for (ExtendedWebElement item: productItemList) {
            while (!removeBtn.isElementPresent()) {
                swipeUp(2000);
            }
            String productName = name.getAttribute("name");
            String productPrice = price.getAttribute("name");
            res += productName + ":";
            res += productPrice + ", ";
        }
        res += "}";
        return res;
    }
}
