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
    public Object saveUser(@RequestBody UserRequest userRequest) {
        System.out.println("-----------****************----------------");
        System.out.println(userRequest.getLoginId());
        Object chk = userService.saveUser(userRequest);
        if(chk == null){
            return "LoginId Exists";
        }
        else{
            return chk;
        }
    }
}
