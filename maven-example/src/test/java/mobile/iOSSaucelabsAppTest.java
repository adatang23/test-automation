package mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import projects.seventh_topic.local.saucelabs.gui.pages.common.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class iOSSaucelabsAppTest implements IAbstractTest, IMobileUtils {

    @Test(priority = 1, dataProvider = "testTypingLoginUser")
    @MethodOwner(owner = "stang")
    public void testTypingLoginUser(String TUID, String username, String password, boolean isLoggedIn) {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
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
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(loginPageBase.isPageOpened(), "Login Page isn't opened");
        ProductListPageBase productListPageBase = loginPageBase.selectValidUser();
        sa.assertTrue(productListPageBase.isPageOpened(), "Product List Page isn't opened");
        sa.assertAll();
    }

    @Test(priority = 3)
    public void testToggle() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        int original = productListPageBase.countDisplayedProductTitles();
        productListPageBase = productListPageBase.clickToggle();
        int afterToggle = productListPageBase.countDisplayedProductTitles();
        sa.assertEquals(original, 6, "The original displayed product title number was incorrect");
        sa.assertEquals(afterToggle, 6, "The displayed product title number after toggle was incorrect");
        sa.assertTrue(original == afterToggle, "The displayed product title number was incorrect");
        sa.assertAll();
    }

    @Test(priority = 4)
    public void testFilterPriceSort() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
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

    @Test(priority = 5)
    public void testFilterNameSort() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        FilterPageBase filterPageBase = productListPageBase.clickFilterBtn();
        productListPageBase = filterPageBase.sortByName();
        List<String> productNames = productListPageBase.getProductNames();
        List<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);
        sa.assertEquals(productNames, sortedNames, "The names were not sorted");
        sa.assertAll();
    }

    @Test(priority = 6, dataProvider = "testProductDetailsPage")
    public void testProductDetailsPage(String TUID, int n, String expectedName, String expectedPrice) {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
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
    public void testDetailsPageAddToCart() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        ProductListPageBase productListPageBase = loginPageBase.quickLogin();
        SoftAssert sa = new SoftAssert();
        ProductDetailsPageBase productDetailsPageBase = productListPageBase.selectProductViewDetails(1);
        productDetailsPageBase.clickAddToCartBtn();
        productListPageBase = productDetailsPageBase.clickBackToProductBtn();
        int cartProductCnt = productListPageBase.getCartProductCnt();
        sa.assertEquals(cartProductCnt, 1, "Cart product count is different");
    }
}
