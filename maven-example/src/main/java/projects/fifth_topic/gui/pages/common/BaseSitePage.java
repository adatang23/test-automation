package projects.fifth_topic.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import projects.fifth_topic.gui.components.Header;

public class BaseSitePage extends AbstractPage {

    @FindBy(xpath = "//body[1]")
    private Header header;

    public BaseSitePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeaderMenu() {
        return header;
    }
}
