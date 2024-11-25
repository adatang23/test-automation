package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MessageForm extends AbstractUIObject {

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private ExtendedWebElement errorMessage;

    public MessageForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String signInFailed() {
        return errorMessage.getText();
    }
}
