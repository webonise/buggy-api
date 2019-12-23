package com.webonise.login.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserEntity;
import com.webonise.login.model.UserRequest;
import com.webonise.login.service.UserService;

@RestController("/user")
@RequestMapping("/")
public class SignUpController {
	
	static Log logger = LogFactory.getLog(SignUpController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO saveUser(@RequestBody UserRequest userRequest) {
    	int check = userService.checkUser(userRequest.getLoginId());
    	logger.info(check);
    	if(check>0) {
    		UserDTO data = new UserDTO(new UserEntity());
    		return data;
    		
    	}else {
    		
    		return userService.saveUser(userRequest);
    	
    	}
		
    }
}
