package tests.ui;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;

@ExtendWith(SerenityJUnit5Extension.class)
public class HomePageTest extends HomePage {

    @Test
    void verifyHomePage() {

        openHomePage();

        verifyHomePageTitle();
    }
}