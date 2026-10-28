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
public class DeleteUserTest extends BaseTest {

    private final UserAPI userAPI = new UserAPI();

    @Test
    void deleteUser() {

        // Create a user first
        User user = UserFactory.createUser();

        Response createResponse = userAPI.createUser(user);

        int userId = createResponse.jsonPath().getInt("id");

        // Delete the created user
        Response deleteResponse = userAPI.deleteUser(userId);

        // Validate delete response
        Assertions.assertEquals(
                StatusCodes.NO_CONTENT,
                deleteResponse.statusCode(),
                "User deletion failed"
        );
    }
}