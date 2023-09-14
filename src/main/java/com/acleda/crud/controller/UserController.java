package com.acleda.crud.controller;

import com.acleda.crud.base.Rest;
import com.acleda.crud.entity.Customer;
import com.acleda.crud.entity.Role;
import com.acleda.crud.entity.User;
import com.acleda.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @PostMapping
    public Rest<?> saveUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return Rest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Customer have been created!")
                .timestamp(timestamp)
                .data(user1)
                .build();
    }
}
