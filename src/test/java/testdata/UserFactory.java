package testdata;

import models.User;

public class UserFactory {

    public static User createUser() {

        long timestamp =
                System.currentTimeMillis();

        return new User(
                "User_" + timestamp,
                "user" + timestamp + "@mail.com",
                "male",
                "active"
        );
    }
}