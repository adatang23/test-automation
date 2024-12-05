package projects.fifth_topic.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import projects.fifth_topic.gui.components.Header;
import projects.fifth_topic.gui.components.NavigationBar;

public class BaseSitePage extends AbstractPage {

    @FindBy(xpath = "//header[@class='page-header']")
    private Header header;

    @FindBy(id = "store.menu")
    private NavigationBar navigationBar;

    public BaseSitePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeaderMenu() {
        return header;
    }

    public NavigationBar getNavigationBar() { return navigationBar; }
}
