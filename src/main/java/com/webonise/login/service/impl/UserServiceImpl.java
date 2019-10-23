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
    public UserDTO saveUser(UserRequest userRequest) {
        UserEntity userEntity = userEntityDao.save(new UserEntity(userRequest));
        return new UserDTO(userEntity);
    }

    @Override
    public boolean login(String loginId, String password) {
        //We are getting the issue because we are trying to fetch single record but with condition specified we have two records
        //in database. we can solve this in two way one is specified here
        List<UserEntity> user = userEntityDao.findAllByLoginIdAndPassword(loginId, password);
        return !user.isEmpty();


        //todo another way to solve this issue is
        /*
        1.remove duplicate entries from user table
        2.add liquibase changelog - change set for   <sql>alter table user add  constraint unique (LOGIN_ID);</sql>
        3.keep same code

            UserEntity user = userEntityDao.findByLoginIdAndPassword(loginId, password);
            return user != null;

         */
    }
}
