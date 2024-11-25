package projects.fifth_topic.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import projects.fifth_topic.gui.pages.common.BaseSitePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseSitePage {

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://magento.softwaretestingboard.com/");
    }
}
