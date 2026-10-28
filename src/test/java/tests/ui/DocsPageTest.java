package tests.ui;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.DocsPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class DocsPageTest extends DocsPage {

    @Test
    void verifyDocsPage() {

        openDocsPage();

        verifyDocsPageLoaded();
    }
}