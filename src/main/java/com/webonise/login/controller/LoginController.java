package com.webonise.login.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webonise.login.LoginApplication;
import com.webonise.login.model.LoginRequest;
import com.webonise.login.service.UserService;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;
    

	private static final Logger logger = Logger.getLogger(LoginController.class);

    @GetMapping
    public String login() {
    	 if(logger.isDebugEnabled()){
	            logger.debug("Login method executed!");
	        }
        return "Welcome to login App";
    }

   

    @PostMapping("/user/login")
    public boolean login(@RequestBody LoginRequest loginRequest) {
    	if(logger.isDebugEnabled()){
            logger.debug("User login method executed!");
        }
        return userService.login(loginRequest.getLoginId(), loginRequest.getPassword());
    }
    
}
