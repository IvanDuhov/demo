package com.modis.demoapi.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modis.demoapi.utils.StringValidator;
import com.modis.demoapi.persistence.model.status.Status;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(value = AccessLevel.PUBLIC)
public class User {
    public String username;
    public String email;
    @JsonIgnore
    public String password;
    public Status status;

    public User(String username, String email, String password, Status status) {
        if (!StringValidator.isUsernameValid(username)
                || !StringValidator.isPasswordValid(password)
                || !StringValidator.isEmailValid(email)) {
            throw new RuntimeException("Not valid values for creating a user!");
        }

        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public void updateUsername(String newUsername) {
        // Validate the new username
        if (!StringValidator.isUsernameValid(newUsername)) {
            throw new RuntimeException("Not a valid username!");
        }

        this.username = newUsername;
    }

    public void updatePassword(String newPassword) {
        // Validate the new password
        if (!StringValidator.isPasswordValid(newPassword)) {
            throw new RuntimeException("Not a valid password!");
        }

        this.password = newPassword;
    }

    public void updateEmail(String newEmail) {
        // Validate the new email
        if (!StringValidator.isEmailValid(newEmail)) {
            throw new RuntimeException("Not a valid password!");
        }

        this.email = newEmail;
    }

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return String.format("Username: %s, Email: %s, Status: %s", username, email, status.toString());
    }

}
