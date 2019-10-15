package com.webonise.login.service;

import com.webonise.login.model.UserRequest;

public interface UserService {

    /**
     * The service saves the userRequest in to the database
     *
     * @return UserDTO
     * @param userRequest
     */
    String saveUser(UserRequest userRequest) throws RuntimeException;

    /**
     * The Service for user login
     *
     * @param loginId
     * @param password
     * @return boolean
     */
    boolean login(String loginId, String password);
}
