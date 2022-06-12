package com.modis.demoapi.utils;

import java.util.regex.Pattern;

public class StringValidator {
    private static final String USERNAME_PATTERN =
            "[^\\\\\\\\<>]";
    private static final String PASSWORD_PATTERN =
            "[^\\\\\\\\<>]";
    private static final String EMAIL_PATTERN =
            "[^\\\\\\\\<>]";

    private static Pattern pattern;

    public static boolean isUsernameValid(final String username) {
        pattern = Pattern.compile(USERNAME_PATTERN);

        return !pattern.matcher(username).matches();
    }

    public static boolean isPasswordValid(final String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);

        return !pattern.matcher(password).matches();
    }

    public static boolean isEmailValid(final String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);

        return !pattern.matcher(email).matches();
    }

}