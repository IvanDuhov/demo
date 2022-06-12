package com.modis.demoapi;

import static org.assertj.core.api.Assertions.assertThat;

import com.modis.demoapi.persistence.model.status.Status;
import com.modis.demoapi.utils.UserGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserGeneratorTests {

    @Test
    public void testGenerateUser() {
        var user = UserGenerator.generateUsers(2);

        assertThat(user).size().isEqualTo(2);
    }

    @Test
    public void testPseudoRandomStatus() {
        List<Status> statuses = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            statuses.add(UserGenerator.generatePseudoRandomStatus());
        }

        assertThat(statuses).contains(Status.ACTIVE);
        assertThat(statuses).contains(Status.INACTIVE);
    }

}
