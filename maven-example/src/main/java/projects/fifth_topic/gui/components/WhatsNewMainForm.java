package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.desktop.*;
import java.util.ArrayList;
import java.util.List;

public class WhatsNewMainForm extends AbstractUIObject {

    @FindBy(xpath = "//h1[@class='page-title']//span[@class='base']")
    private ExtendedWebElement whatsNewMainFormTitle;

    @FindBy(xpath = "/html/body/div[2]/main/div[4]/div[2]/div/div/ul[@class='items']//li")
    private List<ExtendedWebElement> items;

    public WhatsNewMainForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isWhatsNewMainFormTitlePresent() {
        return whatsNewMainFormTitle.isDisplayed();
    }

    public String getWhatsNewMainFormTitleText(String formTitle) {
        whatsNewMainFormTitle.format(formTitle);
        return whatsNewMainFormTitle.getText();
    }

    public List<String> getItemsNames() {
        List<String> itemsNames = new ArrayList<>();
        for (ExtendedWebElement item: items) {
            String currentName = item.getText();
            itemsNames.add(currentName);
        }
        return itemsNames;
    }
}
