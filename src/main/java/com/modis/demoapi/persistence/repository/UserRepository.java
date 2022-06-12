package com.modis.demoapi.persistence.repository;

import com.modis.demoapi.persistence.model.User;
import com.modis.demoapi.persistence.model.status.Status;
import java.util.List;
import java.util.Optional;

public interface UserRepository{

    Optional<List<User>> findByStatus(Status status);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    int countStatus(Status status);
}
