package projects.fifth_topic.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.common.BaseSitePage;
import projects.fifth_topic.gui.components.*;

public class MenPage extends BaseSitePage {

    @FindBy(id = "maincontent")
    private MenMainForm mainContent;

    public MenPage(WebDriver driver) {
        super(driver);
    }

    public MenMainForm getMenMainForm() {
        return mainContent;
    }
}
