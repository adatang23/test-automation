package mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import projects.sixth_topic.web.wikipedia.gui.pages.android.*;

public class AndroidWikipediaWebTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AndroidSaucelabsAppTest.class);

    @Test(priority = 1)
    @MethodOwner(owner = "stang")
    public void verifyNavigationPageTitle() {
        AndroidHomePage homePage = new AndroidHomePage(getDriver());
        homePage.open();
        LOGGER.info("Wikipedia page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isHeaderPresent());
        sa.assertTrue(homePage.isSearchBarBtnPresent());
        sa.assertAll();
    }

    @Test(priority = 2)
    @MethodOwner(owner = "stang")
    public void verifySearchResults() {
        AndroidHomePage homePage = new AndroidHomePage(getDriver());
        homePage.open();
        LOGGER.info("Wikipedia page is opened");
        SoftAssert sa = new SoftAssert();
        AndroidSearchPage searchPage = homePage.clickSearchBarBtn();
        AndroidSearchResultPage resultPage = searchPage.search("chrome driver");
        String expected = "ChromeOS, Graphical user interface, Browser wars, Hummer H2, Headless browser, ";
        String actual = resultPage.getFirstFiveResultTitles();
        sa.assertEquals(actual, expected, "Search results are different");
        sa.assertAll();
    }
}
