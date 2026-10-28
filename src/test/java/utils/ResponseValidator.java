package utils;

import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseValidator {

    public static void validateStatusCode(
            Response response,
            int expected) {

        assertEquals(
                expected,
                response.statusCode()
        );
    }
}