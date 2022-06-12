package com.modis.demoapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.modis.demoapi.persistence.model.status.Status;
import com.modis.demoapi.persistence.repository.MockedPersistenceContext;
import com.modis.demoapi.persistence.repository.UserRepositoryImpl;
import com.modis.demoapi.service.UserService;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    UserService userService =
            new UserService(new UserRepositoryImpl(new MockedPersistenceContext()));

    @Test
    public void testGetByStatus() {
        var users = userService.getByStatus(Status.ACTIVE);

        assertThat(users).isNotEmpty();

        for (var user : users) {
            assertThat(user.getStatus()).isEqualTo(Status.ACTIVE);
        }
    }

    @Test
    public void testGetByEmailSuccessful() {
        var user = userService.getByStatus(Status.ACTIVE).get(0);

        var sameUser = userService.getByEmail(user.getEmail());

        assertThat(user).isEqualTo(sameUser);
    }

    @Test
    public void testGetByEmailNotFound() {
        assertThrows(NoSuchElementException.class, () -> {
            var user = userService.getByEmail("impossibleEmail<>@!#)");
        });
    }

}
