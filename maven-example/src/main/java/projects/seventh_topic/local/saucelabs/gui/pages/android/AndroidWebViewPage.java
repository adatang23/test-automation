package projects.seventh_topic.local.saucelabs.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.WebViewPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class AndroidWebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"WEBVIEW SELECTION\"]")
    private ExtendedWebElement title;

    public AndroidWebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }
}
