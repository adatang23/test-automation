import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import projects.fifth_topic.gui.pages.desktop.*;
import static projects.fifth_topic.constant.ProjectConstant.*;
import org.testng.asserts.SoftAssert;


public class CarinaWebTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarinaWebTest.class);

    @Test(priority = 1)
    @MethodOwner(owner = "stang")
    public void verifyHomePagePresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        sa.assertTrue(homePage.getHeaderMenu().isLogoPresent(), "Logo is not present");
        sa.assertAll();
    }


    @Test(priority = 2)
    @MethodOwner(owner = "stang")
    public void verifySignInFormPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInLink();
        sa.assertTrue(signInPage.isTitlePresent(), "SignIn Form is not visible");
        String actualTitle = signInPage.getTitle();
        sa.assertEquals(actualTitle, "Customer Login", "Sign In Form Title does not match");
        sa.assertAll();
    }


    @Test(priority = 3)
    @MethodOwner(owner = "stang")
    public void verifySignInFormContent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInLink();
        sa.assertTrue(signInPage.isEmailBlankPresent(), "Email Field is not visible");
        sa.assertTrue(signInPage.isPasswordBlankPresent(), "Password Field is not visible");
        sa.assertTrue(signInPage.isSignInButtonPresent(), "SignIn Button is not visible");
        sa.assertAll();
    }


    @Test(priority = 4, dataProvider = "testSignInErrorTypes")
    @MethodOwner(owner = "stang")
    public void testSignInErrorTypes(String TUID, String inputEmail, String inputPassword, String emailError, String passwordError) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInLink();
        signInPage.inputEmailBlank(inputEmail);
        signInPage.inputPasswordBlank(inputPassword);
        signInPage.clickMyAccountSignInButtonError();
        String emailErrorMsg = signInPage.getEmailErrorMsg();
        String passwordErrorMsg = signInPage.getPasswordErrorMsg();
        sa.assertEquals(emailErrorMsg, emailError, "Email error message is different");
        sa.assertEquals(passwordErrorMsg, passwordError, "Password error message is different");
        sa.assertAll();
    }

    @DataProvider(name = "testSignInErrorTypes")
    public Object[][] testSignInErrorTypesDataProvider() {
        return new Object[][]{
                {"TUID: no email and password input", "", "", "This is a required field.", "This is a required field."},
                {"TUID: invalid email and no password input", "abcde", "", "Please enter a valid email address (Ex: johndoe@domain.com).", "This is a required field."},
                {"TUID: invalid email and no passoword input", "abcde@yahoo", "", "Please enter a valid email address (Ex: johndoe@domain.com).", "This is a required field."}
        };
    }


    @Test(priority = 5, dataProvider = "verifySignIn")
    @MethodOwner(owner = "stang")
    public void verifySignIn(String userName, String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInLink();
        signInPage.signIn(email, password);
        String name = homePage.getHeaderMenu().getUserName();
        sa.assertEquals(name, userName, "The user name is different");
        sa.assertAll();
    }

    @DataProvider(parallel = false, name = "verifySignIn")
    public static Object[][] dataprovider3() {
        return new Object[][] {
                {"Welcome, James Smith!", "james.smith@gmail.com", "12345678@js"},
                {"Welcome, Mary Johnson!", "mary.johnson@yahoo.com", "123@abcdef"}
        };
    }


    @Test(priority = 6)
    @MethodOwner(owner = "stang")
    public void verifyCreateAccountFormPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        CreateAccountPage createAccountPage = homePage.getHeaderMenu().clickCreateAccountButton();
        String createAccountFormTitle = createAccountPage.getCreateAccountForm().getTitleText(CREATE_ACCOUNT_FORM_TITLE);
        sa.assertEquals(createAccountFormTitle, CREATE_ACCOUNT_FORM_TITLE, "The title does not match");
        sa.assertAll();
    }


    @Test(priority = 7)
    @MethodOwner(owner = "stang")
    public void verifyCreateAccountFormContent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        CreateAccountPage createAccountPage = homePage.getHeaderMenu().clickCreateAccountButton();
        sa.assertTrue(createAccountPage.getCreateAccountForm().isFirstNamePresent(), "First Name Field is not visible");
        sa.assertTrue(createAccountPage.getCreateAccountForm().isLastNamePresent(), "Last Name Field is not visible");
        sa.assertTrue(createAccountPage.getCreateAccountForm().isEmailPresent(), "Email Field is not visible");
        sa.assertTrue(createAccountPage.getCreateAccountForm().isPasswordPresent(), "Password Field is not visible");
        sa.assertTrue(createAccountPage.getCreateAccountForm().isConfirmPasswordPresent(), "Confirm Password Field is not visible");
        sa.assertAll();
    }


    @Test(priority = 8)
    @MethodOwner(owner = "stang")
    public void verifyCreateAccountFormErrorMsg() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        sa.assertAll();
        CreateAccountPage createAccountPage = homePage.getHeaderMenu().clickCreateAccountButton();
        createAccountPage.getCreateAccountForm().createAccountButtonClick();
        if (createAccountPage.getCreateAccountForm().isFirstNameErrorMsgPresent()
                && createAccountPage.getCreateAccountForm().isPasswordErrorMsgPresent()) {
            sa.assertEquals(createAccountPage.getCreateAccountForm().getFirstNameErrorMsg(), "This is a required field.");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getLastNameErrorMsg(), "This is a required field.");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getEmailErrorMsg(), "This is a required field.");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getPasswordErrorMsg(), "This is a required field.");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getPasswordStrength(), "No Password");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getConfirmPasswordErrorMsg(), "This is a required field.");
            sa.assertAll();
        }
    }


    @Test(priority = 9, dataProvider = "verifyNavigationPageTitlePresent")
    @MethodOwner(owner = "stang")
    public void verifyNavigationPageTitlePresent(String TUID, String pageName, String expectedTitle) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        NavigationPage whatsNewPage = homePage.getNavigationBar().clickNavigationLink(pageName);
        sa.assertTrue(whatsNewPage.isPageTitlePresent(), "Title is not visible");
        String whatsNewTitle = whatsNewPage.getPageTitle();
        sa.assertEquals(whatsNewTitle, expectedTitle, "Title does not match");
        sa.assertAll();
    }

    @DataProvider(name = "verifyNavigationPageTitlePresent")
    public Object[][] verifyNavigationPageTitlePresentDataProvider() {
        return new Object[][] {
                {"TUID: open What's New Page", "What's New", "What's New"},
                {"TUID: open Women Page", "Women", "Women"},
                {"TUID: open Men Page", "Men", "Men"},
                {"TUID: open Gear Page", "Gear", "Gear"},
                {"TUID: open Sale Page", "Sale", "Sale"},
        };
    }


    @Test(priority = 10, dataProvider = "verifySidebarMainOfNavigationPage")
    @MethodOwner(owner = "stang")
    public void verifySidebarMainOfNavigationPage(String TUID, String pageName, String expectedNames) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        NavigationPage whatsNewPage = homePage.getNavigationBar().clickNavigationLink(pageName);
        String actualNames = whatsNewPage.getCategoriesMenu().getItemNames();
        sa.assertEquals(actualNames, expectedNames, "The items' names are not same");
        sa.assertAll();
    }

    @DataProvider(name = "verifySidebarMainOfNavigationPage")
    public Object[][] verifySidebarMainOfNavigationPageDataProvider() {
        return new Object[][] {
                {"TUID: open What's New Page", "What's New", "{ Hoodies & Sweatshirts, Jackets, Tees, Bras & Tanks, Pants, Shorts, Hoodies & Sweatshirts, Jackets, Tees, Tanks, Pants, Shorts, }"},
                {"TUID: open Women Page", "Women", "{ Hoodies & Sweatshirts, Jackets, Tees, Bras & Tanks, Pants, Shorts, }"},
                {"TUID: open Men Page", "Men", "{ Hoodies & Sweatshirts, Jackets, Tees, Tanks, Pants, Shorts, }"},
                {"TUID: open Gear Page", "Gear", "{ Bags, Fitness Equipment, Watches, }"},
                {"TUID: open Sale Page", "Sale", "{ Hoodies and Sweatshirts, Jackets, Tees, Bras & Tanks, Pants, Shorts, Hoodies and Sweatshirts, Jackets, Tees, Pants, Shorts, Bags, Fitness Equipment, }"}
        };
    }
}
