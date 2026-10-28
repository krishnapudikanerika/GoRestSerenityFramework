package config;

public class Environment {

    private Environment(){}

    public static final String BASE_URL =
            "https://gorest.co.in/public/v2";

    public static final String TOKEN =
            System.getProperty(
                    "token",
                    "32c3e745df9df2ecbec83fe789dc01f31611cf6c4fb1b02f3b24ee9395a27d7b"
            );
}