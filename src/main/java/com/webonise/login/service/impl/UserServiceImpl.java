package com.webonise.login.service.impl;

import com.webonise.login.controller.LoginController;
import com.webonise.login.dao.UserEntityDao;
import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.model.UserEntity;
import com.webonise.login.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityDao userEntityDao;

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
    @Override
    public UserDTO saveUser(UserRequest userRequest) {
    UserEntity userEntity =null;
    try
    {
    	 logger.debug("Saving in DB..............");
         userEntity = userEntityDao.save(new UserEntity(userRequest));
         
    }
    catch(Exception e)
    {
	   //can use logger here
    	 logger.error("%%%%%%%%%"+e.getMessage());
    }
    return new UserDTO(userEntity);
    }

    @Override
    public boolean login(String loginId, String password) {
    	logger.debug("Login in  with username & password..............");
        UserEntity user = userEntityDao.findByLoginIdAndPassword(loginId, password);
        return user != null;
    }
}
