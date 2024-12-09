package projects.seventh_topic.local.saucelabs.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = TopMenuPageBase.class)
public class iOSTopMenuPage extends TopMenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-Close")
    private ExtendedWebElement closeBtn;

    @ExtendedFindBy(accessibilityId = "test-ALL ITEMS")
    private ExtendedWebElement allItems;

    @ExtendedFindBy(accessibilityId = "test-WEBVIEW")
    private ExtendedWebElement webView;

    @ExtendedFindBy(accessibilityId = "test-QR CODE SCANNER")
    private ExtendedWebElement qrCodeScanner;

    @ExtendedFindBy(accessibilityId = "test-GEO LOCATION")
    private ExtendedWebElement geoLocation;

    @ExtendedFindBy(accessibilityId = "test-DRAWING")
    private ExtendedWebElement drawing;

    @ExtendedFindBy(accessibilityId = "test-ABOUT")
    private ExtendedWebElement about;

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logout;

    @ExtendedFindBy(accessibilityId = "test-RESET APP STATE")
    private ExtendedWebElement reset;

    public iOSTopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTopMainMenuOpen() {
        return allItems.isElementPresent();
    }

    @Override
    public void closeTopMainMenu() {
        closeBtn.click();
    }

    @Override
    public ProductListPageBase selectAllItems() {
        allItems.click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public WebViewPageBase selectWebView() {
        webView.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }

    @Override
    public DrawingPageBase selectDrawing() {
        drawing.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }

    @Override
    public LoginPageBase selectLogout() {
        logout.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
}
