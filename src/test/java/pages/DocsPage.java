package pages;

import constants.URLs;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class DocsPage extends PageObject {

    private final By docsLink =
            By.linkText("Docs");

    public void openDocsPage() {

        openUrl(URLs.DOCS);
    }

    public void verifyDocsPageLoaded() {

        Assertions.assertTrue(
                getDriver()
                        .getCurrentUrl()
                        .contains("gorest")
        );
    }

    public String getCurrentUrl() {

        return getDriver()
                .getCurrentUrl();
    }
}