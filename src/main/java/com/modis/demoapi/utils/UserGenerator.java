package com.modis.demoapi.utils;

import com.modis.demoapi.persistence.model.User;
import com.modis.demoapi.persistence.model.status.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator {

    public static List<User> generateUsers(Integer count) {
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            users.add(generateUser());
        }

        return users;
    }

    private static User generateUser() {
        return new User(generatePseudoRandomString(), generatePseudoRandomString(),
                generatePseudoRandomString(), generatePseudoRandomStatus());
    }

    private static String generatePseudoRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public static Status generatePseudoRandomStatus() {
        return new Random().nextInt(2) == 0 ? Status.ACTIVE : Status.INACTIVE;
    }

}
