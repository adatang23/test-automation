package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class WomenMainForm extends AbstractUIObject {

    @FindBy(xpath = "//h1[@class='page-title']//span[@class='base']")
    private ExtendedWebElement womenMainFormTitle;

    @FindBy(xpath = "/html/body/div[2]/main/div[4]/div[2]/div[1]/div[2]/dl/dd/ol[@class='items']//a")
    private List<ExtendedWebElement> items;

    public WomenMainForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isWomenMainFormTitlePresent() {
        return womenMainFormTitle.isDisplayed();
    }

    public String getWomenMainFormTitleText(String formTitle) {
        womenMainFormTitle.format(formTitle);
        return womenMainFormTitle.getText();
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
