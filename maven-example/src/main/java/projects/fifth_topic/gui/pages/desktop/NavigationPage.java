package projects.fifth_topic.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import projects.fifth_topic.gui.components.*;
import projects.fifth_topic.gui.pages.common.BaseSitePage;

public class NavigationPage extends BaseSitePage {

    @FindBy(xpath = "//h1[@id='page-title-heading']/span")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//div[@class='sidebar sidebar-main']")
    private SidebarMain sidebarMain;

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageTitlePresent() { return pageTitle.isDisplayed(); }

    public String getPageTitle() { return pageTitle.getAttribute("innerHTML"); }

    public SidebarMain getCategoriesMenu() { return sidebarMain; }
}
