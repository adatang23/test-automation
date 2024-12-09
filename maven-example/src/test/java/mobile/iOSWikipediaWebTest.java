package mobile;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import projects.seventh_topic.web.wikipedia.gui.pages.common.*;

public class iOSWikipediaWebTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(iOSWikipediaWebTest.class);

    @Test(priority = 1)
    @MethodOwner(owner = "stang")
    public void verifyHomePage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LOGGER.info("Wikipedia page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isHeaderPresent());
        sa.assertTrue(homePage.isSearchBarBtnPresent());
        sa.assertAll();
    }

    @Test(priority = 2)
    @MethodOwner(owner = "stang")
    public void verifySearchPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LOGGER.info("Wikipedia page is opened");
        SoftAssert sa = new SoftAssert();
        SearchPageBase searchPage = homePage.clickSearchBarBtn();
        sa.assertTrue(searchPage.isSearchbarPresent(), "Search bar is not visible");
        sa.assertTrue(searchPage.isReturnBtnPresent(), "Return button is not visible");
        sa.assertAll();
    }
}
