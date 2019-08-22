package com.webonise.login.controller;

import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO saveUser(@RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }
}
