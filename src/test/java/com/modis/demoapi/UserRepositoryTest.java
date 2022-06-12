package com.modis.demoapi;

import static org.assertj.core.api.Assertions.assertThat;

import com.modis.demoapi.persistence.model.status.Status;
import com.modis.demoapi.persistence.repository.MockedPersistenceContext;
import com.modis.demoapi.persistence.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    UserRepositoryImpl repository = new UserRepositoryImpl(new MockedPersistenceContext());

    @Test
    public void testFindByActiveStatus() {
        var activeUsers = repository.findByStatus(Status.ACTIVE);

        assertThat(activeUsers).isNotEmpty();

        for (var user : activeUsers.get()) {
            assertThat(user.getStatus()).isEqualTo(Status.ACTIVE);
        }
    }

    @Test
    public void testFindByInactiveStatus() {
        var activeUsers = repository.findByStatus(Status.INACTIVE);

        assertThat(activeUsers).isNotEmpty();

        for (var user : activeUsers.get()) {
            assertThat(user.getStatus()).isEqualTo(Status.INACTIVE);
        }
    }

}
