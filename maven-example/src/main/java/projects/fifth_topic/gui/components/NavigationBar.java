package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.desktop.NavigationPage;

public class NavigationBar extends AbstractUIObject {

    @FindBy(id = "ui-id-3")
    private ExtendedWebElement whatsNewLink;

    @FindBy(id = "ui-id-4")
    private ExtendedWebElement womenLink;

    @FindBy(id = "ui-id-5")
    private ExtendedWebElement menLink;

    @FindBy(id = "ui-id-6")
    private ExtendedWebElement gearLink;

    @FindBy(id = "ui-id-7")
    private ExtendedWebElement trainingLink;

    @FindBy(id = "ui-id-8")
    private ExtendedWebElement saleLink;

    public NavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public NavigationPage clickNavigationLink(String name) {
        if (name.equals("What's New")) {
            whatsNewLink.click();
            return new NavigationPage(getDriver());
        } else if (name.equals("Women")) {
            womenLink.click();
            return new NavigationPage(getDriver());
        } else if (name.equals("Men")) {
            menLink.click();
            return new NavigationPage(getDriver());
        } else if (name.equals("Gear")) {
            gearLink.click();
            return new NavigationPage(getDriver());
        } else if (name.equals("Training")) {
            trainingLink.click();
            return new NavigationPage(getDriver());
        } else if (name.equals("Sale")) {
            saleLink.click();
            return new NavigationPage(getDriver());
        } else {
            return null;
        }
    }
}
