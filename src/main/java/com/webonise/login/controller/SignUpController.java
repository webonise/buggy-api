package com.webonise.login.controller;

import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SignUpController {

    @Autowired
    private UserService userService;

    @RequestMapping("/createUser")
    public String saveUser(@RequestBody UserRequest userRequest) {
    	System.out.println("user data:username="+userRequest.getLoginId()+"#tpassword="+userRequest.getPassword());
        return userService.saveUser(userRequest);
    }
}
