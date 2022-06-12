package com.modis.demoapi.web.controller;

import com.modis.demoapi.persistence.model.User;
import com.modis.demoapi.persistence.model.status.Status;
import com.modis.demoapi.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{status}")
    public ResponseEntity<List<User>> hello(@PathVariable Status status) {
        var users = userService.getByStatus(status);

        // TODO: Add pagination
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
