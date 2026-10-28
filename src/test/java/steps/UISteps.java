package steps;

import net.serenitybdd.annotations.Step;
import pages.HomePage;

public class UISteps {

    HomePage homePage;

    @Step("Open Home Page")
    public void openHomePage() {

        homePage.openHomePage();
    }

    @Step("Get Page Title")
    public String getTitle() {

        return homePage.getTitle();
    }
}