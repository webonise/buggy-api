package com.webonise.login.service.impl;

import com.webonise.login.dao.UserEntityDao;
import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.model.UserEntity;
import com.webonise.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityDao userEntityDao;

    @Override
    public String saveUser(UserRequest userRequest) throws RuntimeException {

        UserEntity userEntityExist = userEntityDao.findByLoginId(userRequest.getLoginId());
        
        if(userEntityExist != null) {
        	throw new RuntimeException();
        }
        
        userEntityDao.save(new UserEntity(userRequest));

        return "User Data Inserted Successfully!";
    }

    @Override
    public boolean login(String loginId, String password) {
        UserEntity user = userEntityDao.findByLoginIdAndPassword(loginId, password);
        return user != null;
    }
}
