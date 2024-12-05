package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SidebarMain extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='categories-menu']//li[@class='item']/a")
    private List<ExtendedWebElement> items;

    public SidebarMain(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemNames() {
        String res= "{ ";
        for (ExtendedWebElement item: items) {
            String name = item.getText();
            res += name + ", ";
        }
        res += "}";
        return res;
    }
}
