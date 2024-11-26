package projects.fifth_topic.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.common.BaseSitePage;
import projects.fifth_topic.gui.components.*;

public class WomenPage extends BaseSitePage {

    @FindBy(id = "maincontent")
    private WomenMainForm mainContent;

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    public WomenMainForm getWomenMainForm() {
        return mainContent;
    }
}
