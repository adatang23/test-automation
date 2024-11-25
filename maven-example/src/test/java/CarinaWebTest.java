import com.zebrunner.carina.core.AbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import projects.fifth_topic.gui.components.SignInForm;
import projects.fifth_topic.gui.pages.desktop.*;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;
import static projects.fifth_topic.constant.ProjectConstant.*;
import org.testng.asserts.SoftAssert;

public class CarinaWebTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarinaWebTest.class);

    @Test()
    public void verifyHomePagePresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        sa.assertTrue(homePage.getHeaderMenu().isLogoPresent(), "Logo is not present");
        sa.assertAll();
    }

    @Test()
    public void verifySignInFormPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        sa.assertTrue(signInPage.getSignInForm().isSignInFormTitlePresent(), "SignIn Form is not visible");
        String signInFormTitle = signInPage.getSignInForm().getSignInFormTitle(SIGNIN_FORM_TITLE);
        sa.assertEquals(signInFormTitle, SIGNIN_FORM_TITLE, "Current User SignIn! is not match");
        sa.assertAll();
    }

    @Test()
    public void verifySignInFormContent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        sa.assertTrue(signInPage.getSignInForm().isSignInEmailPresent(), "Email Field is not visible");
        sa.assertTrue(signInPage.getSignInForm().isSignInPasswordPresent(), "Password Field is not visible");
        sa.assertTrue(signInPage.getSignInForm().isSignInButtonPresent(), "SignIn Button is not visible");
        sa.assertAll();
    }

    @Test()
    public void verifySignInFormErrorMsg() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        sa.assertAll();
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        signInPage.getSignInForm().signInButtonClickError();
        if (signInPage.getSignInForm().isEmailErrorMsgPresent() && signInPage.getSignInForm().isPasswordErrorMsgPresent()) {
            sa.assertEquals(signInPage.getSignInForm().getEmailErrorMsgText(), "This is a required field.");
            sa.assertEquals(signInPage.getSignInForm().getPasswordErrorMsgText(), "This is a required field.");
            sa.assertAll();
        }
    }

    @Test()
    public void verifyHomePageUserName() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        String email = "james.smith@gmail.com";
        String password = "12345678@js";
        String userName = "James Smith";
        homePage = signInPage.getSignInForm().signIn(email, password);
        sa.assertTrue(homePage.getHeaderMenu().getUserName().contains(userName), "User Name is incorrect");
        if (homePage.getHeaderMenu().isActionSwitchButtonPresent()) {
            homePage.getHeaderMenu().actionSwitchButtonClick();
            if (homePage.getHeaderMenu().isSignOutHyperLinkPresent()) {
                homePage.getHeaderMenu().signOut();
            }
        }
    }

    @Test()
    public void verifyCreateAccountFormPresent() {

    }

    @Test()
    public void verifyCreateAccountFormContent() {

    }

    @Test()
    public void verifyCreateAccountFormErrorMsg() {

    }

    @Test()
    public void verifyWhatsNewPagePresent() {

    }

    @Test()
    public void verifyWomenPagePresent() {

    }
}
