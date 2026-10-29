package tests.integration;

import api.UserAPI;
import config.Environment;
import constants.StatusCodes;
import io.restassured.response.Response;
import models.User;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ConsolePage;
import pages.HomePage;
import testdata.UserFactory;
import tests.BaseTest;

@ExtendWith(SerenityJUnit5Extension.class)
public class UserIntegrationTest extends BaseTest {

    private final UserAPI userAPI = new UserAPI();
    private final HomePage homePage = new HomePage();
    private final ConsolePage consolePage = new ConsolePage();

    @Test
    void apiUiFlow() throws InterruptedException {

        System.out.println("\n================================");
        System.out.println("INTEGRATION TEST STARTED");
        System.out.println("================================");

        // Create User via API
        User user = UserFactory.createUser();

        Response createResponse = userAPI.createUser(user);

        int userId = createResponse.jsonPath().getInt("id");

        String expectedUserName =
                createResponse.jsonPath().getString("name");

        Assertions.assertEquals(
                StatusCodes.CREATED,
                createResponse.statusCode(),
                "User creation failed"
        );

        // Open Home Page
        homePage.openHomePage();

        homePage.verifyHomePageTitle();

        // Open Console
        consolePage.navigateToConsole();

        // Enter API URL
        consolePage.enterApiUrl(
                Environment.BASE_URL + "/users/" + userId
        );

        // Send Request
        consolePage.clickSend();

        // Fetch user again through API for validation
        Response getResponse =
                userAPI.getUserById(userId);

        String actualUserName =
                getResponse.jsonPath().getString("name");

        Assertions.assertEquals(
                expectedUserName,
                actualUserName,
                "User name mismatch"
        );

        System.out.println("\n================================");
        System.out.println("INTEGRATION TEST PASSED");
        System.out.println("================================");
    }
}