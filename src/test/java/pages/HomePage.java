package pages;

import constants.URLs;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import testdata.UIData;

public class HomePage extends PageObject {

    public void openHomePage() {

        openUrl(URLs.HOME);
    }

    public void verifyHomePageTitle() throws InterruptedException {

        Assertions.assertEquals(
                UIData.HOME_PAGE_TITLE,
                getDriver().getTitle()
        );
    }

    public String getTitle() {

        return getDriver().getTitle();
    }

    public boolean isPageLoaded() {

        return getDriver().getTitle() != null
                && !getDriver().getTitle().isEmpty();
    }
}