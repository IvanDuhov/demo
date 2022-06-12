package com.modis.demoapi.service;

import com.modis.demoapi.persistence.model.User;
import com.modis.demoapi.persistence.model.status.Status;
import com.modis.demoapi.persistence.repository.UserRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getByEmail(String email) {
        var user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new NoSuchElementException("User with that email doesn't exist!");
        }

        return user.get();
    }

    public List<User> getByStatus(Status status) {
        var users = userRepository.findByStatus(status);

        if (users.isEmpty()) {
            throw new NoSuchElementException(
                    String.format("There are no users with %s status!", status.toString()));
        }

        return users.get();
    }

}
