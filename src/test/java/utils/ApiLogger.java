package utils;

public class ApiLogger {

    public static void logRequest(
            String method,
            String endpoint,
            String body) {

        System.out.println();
        System.out.println("================================");
        System.out.println("REQUEST METHOD : " + method);
        System.out.println("REQUEST URL    : " + endpoint);

        if (body != null && !body.isEmpty()) {
            System.out.println("REQUEST BODY   : ");
            System.out.println(body);
        }

        System.out.println("================================");
    }

    public static void logResponse(
            int statusCode,
            String body) {

        System.out.println();
        System.out.println("================================");
        System.out.println("STATUS CODE    : " + statusCode);

        if (body != null && !body.isEmpty()) {
            System.out.println("RESPONSE BODY  : ");
            System.out.println(body);
        } else {
            System.out.println("NO RESPONSE BODY");
        }

        System.out.println("================================");
    }
}