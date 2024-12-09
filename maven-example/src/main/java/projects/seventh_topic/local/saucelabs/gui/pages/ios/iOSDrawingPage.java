package projects.seventh_topic.local.saucelabs.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.DrawingPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class iOSDrawingPage extends DrawingPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"DRAWING\"]")
    private ExtendedWebElement title;

    public iOSDrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return title.getAttribute("name");
    }
}
