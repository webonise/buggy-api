package com.webonise.login.service;

import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;

public interface UserService {

    /**
     * The service saves the userRequest in to the database
     *
     * @return UserDTO
     * @param userRequest
     */
    UserDTO saveUser(UserRequest userRequest);

    /**
     * The Service for user login
     *
     * @param loginId
     * @param password
     * @return boolean
     */
    boolean login(String loginId, String password);
}
