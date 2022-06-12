package com.modis.demoapi.persistence.repository;

import com.modis.demoapi.persistence.model.User;
import com.modis.demoapi.persistence.model.status.Status;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * Implementation of
 * {@link com.modis.demoapi.persistence.repository.UserRepository}
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    private final MockedPersistenceContext db;

    public UserRepositoryImpl(MockedPersistenceContext db) {
        this.db = db;
    }

    @Override
    public Optional<List<User>> findByStatus(Status status) {
        return Optional
                .of(db.getUsers().stream().filter(user -> user.getStatus().equals(status)).collect(
                        Collectors.toList()));
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return db.getUsers().stream().filter(user1 -> user1.getEmail().equals(email)).findFirst();
    }

    @Override
    public int countStatus(Status status) {
        return 0;
    }
}
