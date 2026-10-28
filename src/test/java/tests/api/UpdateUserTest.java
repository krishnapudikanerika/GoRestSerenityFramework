package tests.api;

import api.UserAPI;
import constants.StatusCodes;
import io.restassured.response.Response;
import models.User;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import testdata.TestData;
import testdata.UserFactory;
import tests.BaseTest;

@ExtendWith(SerenityJUnit5Extension.class)
public class UpdateUserTest extends BaseTest {

    private final UserAPI userAPI = new UserAPI();

    @Test
    void updateUser() {

        // Create user
        User user = UserFactory.createUser();

        Response createResponse = userAPI.createUser(user);

        int userId = createResponse.jsonPath().getInt("id");

        // Update user status
        Response updateResponse = userAPI.updateUser(
                userId,
                TestData.INACTIVE
        );

        // Validate status code
        Assertions.assertEquals(
                StatusCodes.OK,
                updateResponse.statusCode(),
                "User update failed"
        );

        // Validate updated status
        Assertions.assertEquals(
                TestData.INACTIVE,
                updateResponse.jsonPath().getString("status"),
                "User status was not updated correctly"
        );
    }
}