package steps;

import api.UserAPI;
import io.restassured.response.Response;
import models.User;
import net.serenitybdd.annotations.Step;

public class ApiSteps {

    UserAPI userAPI = new UserAPI();

    @Step("Create User")
    public Response createUser(User user) {

        return userAPI.createUser(user);
    }

    @Step("Get Users")
    public Response getUsers() {

        return userAPI.getUsers();
    }

    @Step("Get User By Id")
    public Response getUserById(int id) {

        return userAPI.getUserById(id);
    }

    @Step("Delete User")
    public Response deleteUser(int id) {

        return userAPI.deleteUser(id);
    }

    @Step("Update User")
    public Response updateUser(
            int id,
            String status) {

        return userAPI.updateUser(id, status);
    }
}