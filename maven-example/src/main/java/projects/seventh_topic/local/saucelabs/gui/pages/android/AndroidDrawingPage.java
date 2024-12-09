package projects.seventh_topic.local.saucelabs.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.local.saucelabs.gui.pages.common.DrawingPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class AndroidDrawingPage extends DrawingPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"DRAWING\"]")
    private ExtendedWebElement title;

    public AndroidDrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }
}
