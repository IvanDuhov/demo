package com.modis.demoapi.persistence.repository;

import com.modis.demoapi.persistence.model.User;
import com.modis.demoapi.utils.UserGenerator;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MockedPersistenceContext {

    private List<User> users = UserGenerator.generateUsers(100);
}
