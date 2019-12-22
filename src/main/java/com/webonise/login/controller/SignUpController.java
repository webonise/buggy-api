package com.webonise.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.service.UserService;

@RestController("/user")
@RequestMapping("/")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO saveUser(@RequestBody UserRequest userRequest) {
    	int check = userService.checkUser(userRequest.getLoginId());
    	System.err.println(check);
    	if(check>0) {
    		
    		return null;
    		
    	}else {
    		
    		return userService.saveUser(userRequest);
    	
    	}
		
    }
}
