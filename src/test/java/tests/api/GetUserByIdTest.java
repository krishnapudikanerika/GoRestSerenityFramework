package tests.api;

import api.UserAPI;
import constants.StatusCodes;
import io.restassured.response.Response;
import models.User;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import testdata.UserFactory;
import tests.BaseTest;

@ExtendWith(SerenityJUnit5Extension.class)
public class GetUserByIdTest extends BaseTest {

    private final UserAPI userAPI = new UserAPI();

    @Test
    void getUserById() {

        // Create a user
        User user = UserFactory.createUser();

        Response createResponse = userAPI.createUser(user);

        int userId = createResponse.jsonPath().getInt("id");

        // Get the created user
        Response getResponse = userAPI.getUserById(userId);

        // Validate response status
        Assertions.assertEquals(
                StatusCodes.OK,
                getResponse.statusCode(),
                "Failed to retrieve user by ID"
        );
    }
}