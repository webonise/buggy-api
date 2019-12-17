package com.webonise.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webonise.login.model.LoginRequest;
import com.webonise.login.responseHandler.ApiBaseController;
import com.webonise.login.responseHandler.ApiResponse;
import com.webonise.login.service.UserService;

@RestController
@RequestMapping("/")
public class LoginController extends ApiBaseController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String login() {
		return "Welcome to login App";
	}

	@PostMapping("/user/login")
	public ApiResponse login(@RequestBody LoginRequest loginRequest) {
		try {
			Boolean loginStatus = userService.login(loginRequest.getLoginId(), loginRequest.getPassword());
			return response("success", loginStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return response("error", e.getMessage());
		}
	}

}