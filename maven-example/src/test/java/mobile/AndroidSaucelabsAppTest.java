package mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import projects.sixth_topic.local.saucelabs.gui.pages.common.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidSaucelabsAppTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AndroidSaucelabsAppTest.class);

    @Test(priority = 1, dataProvider = "testTypingLoginUser")
    @MethodOwner(owner = "stang")
    public void testTypingLoginUser(String TUID, String username, String password, boolean isLoggedIn) {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        LOGGER.info("Sauce Labs page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(loginPageBase.isPageOpened(), "Login Page isn't opened");
        ProductListPageBase productListPageBase = loginPageBase.login(username, password);
        sa.assertEquals(productListPageBase.isPageOpened(), isLoggedIn, "Page open result is different");
        sa.assertAll();
    }

    @DataProvider(name = "testTypingLoginUser")
    public Object[][] testLoginUserDataProvider() {
        return new Object[][] {
                {"TUID: valid user and password", "standard_user", "secret_sauce", true},
                {"TUID: invalid user", "locked_out_user", "secret_sauce", false},
                {"TUID: problem user", "problem_user", "secret_sauce", true},
        };
    }

    @Test(priority = 2)
    @MethodOwner(owner = "stang")
    public void testSelectValidUserLogin() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        LOGGER.info("Sauce Labs page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(loginPageBase.isPageOpened(), "Login Page isn't opened");
        ProductListPageBase productListPageBase = loginPageBase.selectValidUser();
        sa.assertTrue(productListPageBase.isPageOpened(), "Product List Page isn't opened");
        sa.assertAll();
    }

    @Test(priority = 3, dataProvider = "testTopMainMenu")
    @MethodOwner(owner = "stang")
    public void testTopMainMenu(String TUID, String selection, String expectedTitle) {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        LOGGER.info("Sauce Labs page is opened");
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        TopMenuPageBase topMenuPageBase = productListPageBase.openTopMainMenu();
        String title = null;
        if (selection.equals("All items")) {
            productListPageBase = topMenuPageBase.selectAllItems();
            title = productListPageBase.getTitle();
        } else if (selection.equals("Webview")) {
            WebViewPageBase webViewPageBase = topMenuPageBase.selectWebView();
            title = webViewPageBase.getTitle();
        } else if (selection.equals("Drawing")) {
            DrawingPageBase drawingPageBase = topMenuPageBase.selectDrawing();
            title = drawingPageBase.getTitle();
        } else if (selection.equals("Logout")) {
            loginPageBase = topMenuPageBase.selectLogout();
            if (loginPageBase.isPageOpened()) {
                title = "Login";
            }
        } else if (selection.equals("Close")) {
            title = productListPageBase.getTitle();
        }
        sa.assertEquals(title, expectedTitle, "The page title is different");
        sa.assertAll();
    }

    @DataProvider(name = "testTopMainMenu")
    public Object[][] testTopMainMenuDataProvider() {
        return new Object[][] {
                {"TUID: select All items", "All items", "PRODUCTS"},
                {"TUID: select Webview", "Webview", "WEBVIEW SELECTION"},
                {"TUID: select Drawing", "Drawing", "DRAWING"},
                {"TUID: select Logout", "Logout", "Login"},
                {"TUID: select Close", "Close", "PRODUCTS"}
        };
    }


    @Test(priority = 4)
    public void testToggle() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        LOGGER.info("Sauce Labs page is opened");
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        int original = productListPageBase.countDisplayedProductTitles();
        productListPageBase = productListPageBase.clickToggle();
        int afterToggle = productListPageBase.countDisplayedProductTitles();
        sa.assertEquals(original, 2, "The original displayed product title number was incorrect");
        sa.assertEquals(afterToggle, 5, "The displayed product title number after toggle was incorrect");
        sa.assertTrue(original < afterToggle, "The displayed product title number was incorrect");
        sa.assertAll();
    }

    @Test(priority = 5)
    public void testFilter() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        LOGGER.info("Sauce Labs page is opened");
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        FilterPageBase filterPageBase = productListPageBase.clickFilterBtn();
        productListPageBase = filterPageBase.sortByPrice();
        List<Float> productPrices = productListPageBase.getProductPrices();
        List<Float> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices);
        sa.assertEquals(productPrices, sortedPrices, "The prices were not sorted");
        sa.assertAll();
    }

    @Test(priority = 6, dataProvider = "testProductDetailsPage")
    public void testProductDetailsPage(String TUID, int n, String expectedName, String expectedPrice) {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        LOGGER.info("Sauce Labs page is opened");
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        ProductDetailsPageBase productDetailsPageBase = productListPageBase.selectProductViewDetails(n);
        String name = productDetailsPageBase.getProductName();
        Float price = productDetailsPageBase.getPrice();
        sa.assertEquals(name, expectedName, "Product name is different");
        sa.assertEquals(price, Float.valueOf(expectedPrice), "Price is different");
        sa.assertAll();
    }

    @DataProvider(name = "testProductDetailsPage")
    public Object[][] testProductDetailsPageDataProvider() {
        return new Object[][] {
                {"TUID: select 3rd", 3, "Sauce Labs Bolt T-Shirt", "15.99"},
                {"TUID: select 5th", 5, "Sauce Labs Onesie", "7.99"},
        };
    }

    @Test(priority = 7)
    public void testCartProductCnt() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        LOGGER.info("Sauce Labs page is opened");
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        productListPageBase.selectProductToCart(1);
        productListPageBase.selectProductToCart(2);
        int cartProductCnt = productListPageBase.getCartProductCnt();
        sa.assertEquals(cartProductCnt, 2, "Cart product count is different");
        productListPageBase.removeProductFromCart(1);
        cartProductCnt = productListPageBase.getCartProductCnt();
        sa.assertEquals(cartProductCnt, 1, "Cart product count is different");
        sa.assertAll();
    }

    @Test(priority = 8)
    public void testCartPage() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        LOGGER.info("Sauce Labs page is opened");
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        productListPageBase.selectProductToCart(1);
        productListPageBase.selectProductToCart(2);
        CartPageBase cartPageBase = productListPageBase.clickCartBtn();
        String title = cartPageBase.getTitle();
        sa.assertEquals(title, "YOUR CART", "Page title is different");
        String productInfo = cartPageBase.getAllProductNamePrice();
        sa.assertEquals(productInfo, "{ Sauce Labs Backpack:$29.99, Sauce Labs Bike Light:$9.99, }", "Product information is different");
    }
}
