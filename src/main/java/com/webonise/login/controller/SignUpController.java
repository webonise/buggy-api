package com.webonise.login.controller;

import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@RequestMapping("/")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO saveUser(@RequestBody UserRequest userRequest) {
    	try {
    		return userService.saveUser(userRequest);	
		} catch (Exception e) {
			// TODO: handle exception
			throw new NullPointerException();
		}
    }
}
