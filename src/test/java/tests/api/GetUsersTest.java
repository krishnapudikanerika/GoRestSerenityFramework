package tests.api;

import api.UserAPI;
import constants.StatusCodes;
import io.restassured.response.Response;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.BaseTest;

@ExtendWith(SerenityJUnit5Extension.class)
public class GetUsersTest extends BaseTest {

    private final UserAPI userAPI = new UserAPI();

    @Test
    void getUsers() {

        Response response = userAPI.getUsers();

        Assertions.assertEquals(
                StatusCodes.OK,
                response.statusCode(),
                "Failed to retrieve users"
        );
    }
}