package projects.seventh_topic.local.saucelabs.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.WebViewPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewPageBase.class)
public class iOSWebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WEBVIEW SELECTION\"]")
    private ExtendedWebElement title;

    public iOSWebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return title.getAttribute("name");
    }
}
