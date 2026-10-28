package pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ConsolePage extends PageObject {

    private final By consoleLink =
            By.linkText("Console");

    private final By urlTextBox =
            By.id("rsq_url");

    private final By sendButton =
            By.id("rsq_send");

    public void navigateToConsole() {

        $(consoleLink).waitUntilClickable()
                .click();
    }

    public void enterApiUrl(String apiUrl) {

        $(urlTextBox)
                .waitUntilVisible()
                .type(apiUrl);
    }

    public void clickSend() {

        $(sendButton)
                .waitUntilClickable()
                .click();
    }


}