package projects.seventh_topic.web.wikipedia.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.seventh_topic.web.wikipedia.gui.pages.common.SearchResultPageBase;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class AndroidSearchResultPage extends SearchResultPageBase {

    @FindBy(xpath = "//ul[@class='mw-search-results']/li")
    private List<ExtendedWebElement> displayedResultsList;

    public AndroidSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getFirstFiveResultTitles() {
        String res = "";
        int i = 1;
        for (ExtendedWebElement item: displayedResultsList) {
            String name = item.findExtendedWebElement(By.xpath(".//a[1]")).getAttribute("title");
            res += name + ", ";
            if (i == 5) {
                return res;
            }
            if (item.isElementPresent() && i < 5) {
                swipeUp(2000);
            }
            i++;
        }
        return res;
    }
}
