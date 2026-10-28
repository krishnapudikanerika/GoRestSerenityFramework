package api;

import com.google.gson.Gson;
import constants.Endpoints;
import io.restassured.response.Response;
import models.User;
import net.serenitybdd.annotations.Step;
import utils.ApiLogger;

public class UserAPI extends BaseAPI {

    private final Gson gson = new Gson();
    @Step("Create User Through API")
    public Response createUser(User user) {

        ApiLogger.logRequest(
                "POST",
                Endpoints.USERS,
                gson.toJson(user));

        Response response =
                request()
                        .body(user)
                        .post(Endpoints.USERS);

        ApiLogger.logResponse(
                response.statusCode(),
                response.getBody().asString());

        return response;
    }

    @Step("Get Users")
    public Response getUsers() {

        ApiLogger.logRequest(
                "GET",
                Endpoints.USERS,
                null);

        Response response =
                request()
                        .get(Endpoints.USERS);

        ApiLogger.logResponse(
                response.statusCode(),
                response.getBody().asString());

        return response;
    }
    @Step("Get User By ID")
    public Response getUserById(int userId) {

        ApiLogger.logRequest(
                "GET",
                "/users/" + userId,
                null);

        Response response = request()
                .pathParam("id", userId)
                .get(Endpoints.USER_BY_ID);

        ApiLogger.logResponse(
                response.statusCode(),
                response.getBody().asString());

        return response;
    }

    @Step("Update User")
    public Response updateUser(
            int userId,
            String status) {

        String body =
                "{\"status\":\"" + status + "\"}";

        ApiLogger.logRequest(
                "PATCH",
                "/users/" + userId,
                body);

        Response response = request()
                .pathParam("id", userId)
                .body(body)
                .patch(Endpoints.USER_BY_ID);

        ApiLogger.logResponse(
                response.statusCode(),
                response.getBody().asString());

        return response;
    }

    @Step("Delete User")
    public Response deleteUser(int userId) {

        ApiLogger.logRequest(
                "DELETE",
                "/users/" + userId,
                null);

        Response response = request()
                .pathParam("id", userId)
                .delete(Endpoints.USER_BY_ID);

        ApiLogger.logResponse(
                response.statusCode(),
                "NO RESPONSE BODY");

        return response;
    }
}