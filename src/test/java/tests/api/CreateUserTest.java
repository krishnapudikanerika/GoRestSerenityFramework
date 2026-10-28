package tests.api;

import api.UserAPI;
import constants.StatusCodes;
import models.User;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import testdata.UserFactory;
import tests.BaseTest;

@ExtendWith(SerenityJUnit5Extension.class)
public class CreateUserTest extends BaseTest {

    private final UserAPI api = new UserAPI();

    @Test
    void createUser() {

        User user = UserFactory.createUser();

        int statusCode = api.createUser(user)
                .then()
                .extract()
                .statusCode();

        Assertions.assertEquals(
                StatusCodes.CREATED,
                statusCode,
                "User creation failed"
        );
    }
}