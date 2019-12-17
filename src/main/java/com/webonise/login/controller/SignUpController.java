package com.webonise.login.controller;

import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.responseHandler.ApiBaseController;
import com.webonise.login.responseHandler.ApiResponse;
import com.webonise.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@RequestMapping("/")
public class SignUpController extends ApiBaseController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ApiResponse saveUser(@RequestBody UserRequest userRequest) {
		try {
			UserDTO userDTO = userService.saveUser(userRequest);
			return response("success", userDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return response("error", e.getMessage());
		}
	}
}