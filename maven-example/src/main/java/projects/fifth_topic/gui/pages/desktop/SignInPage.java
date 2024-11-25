package projects.fifth_topic.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.common.BaseSitePage;
import projects.fifth_topic.gui.components.*;

public class SignInPage extends BaseSitePage {

    @FindBy(xpath = "//div[@class='block block-customer-login']")
    private SignInForm signInForm;

    @FindBy(xpath = "//div[@class='page messages']")
    private MessageForm messageForm;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInForm getSignInForm() {
        return signInForm;
    }

    public MessageForm getMessageForm() {
        return messageForm;
    }
}
