package projects.fifth_topic.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.common.BaseSitePage;
import projects.fifth_topic.gui.components.*;

public class WhatsNewPage extends BaseSitePage {

    @FindBy(id = "maincontent")
    private WhatsNewMainForm mainContent;

    public WhatsNewPage(WebDriver driver) {
        super(driver);
    }

    public WhatsNewMainForm getWhatsNewMainForm() {
        return mainContent;
    }
}
