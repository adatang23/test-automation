package projects.fifth_topic.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MessageForm extends AbstractComponent {

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private ExtendedWebElement errorMessage;

    public MessageForm(SearchContext searchContext, WebDriver driver) {
        super(searchContext, driver);
    }

    public String signInFailed() {
        return errorMessage.getText();
    }
}
