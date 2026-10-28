package api;

import config.Environment;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseAPI {

    protected RequestSpecification request() {

        return given()
                .baseUri(Environment.BASE_URL)
                .header(
                        "Authorization",
                        "Bearer " + Environment.TOKEN)
                .header(
                        "Content-Type",
                        "application/json");
    }
}