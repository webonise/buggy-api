package com.webonise.login.responseHandler;

public class ApiBaseController {

	protected ApiResponse response(String status, Object message) {

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(message);
		apiResponse.setStatus(status);
		return apiResponse;
	}
}