package projects.fifth_topic.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import projects.fifth_topic.gui.pages.common.BaseSitePage;
import projects.fifth_topic.gui.components.*;

public class CreateAccountPage extends BaseSitePage {

    @FindBy(xpath = "//main[@class='page-main']")
    private CreateAccountForm createAccountForm;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountForm getCreateAccountForm() {
        return createAccountForm;
    }
}
