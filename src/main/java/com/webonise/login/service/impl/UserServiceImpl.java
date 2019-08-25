package com.webonise.login.service.impl;

import com.webonise.login.dao.UserEntityDao;
import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.model.UserEntity;
import com.webonise.login.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityDao userEntityDao;

    @Override
    public UserDTO saveUser(UserRequest userRequest) {
    	UserEntity userEntity=null;
    	Set<UserRequest> set= userRequest.getUserSet();
    	List<UserRequest> list= new ArrayList<>(set);
    	for(UserRequest request:list){
         userEntity = userEntityDao.save(new UserEntity(request));
        		 }
        return new UserDTO(userEntity);      
    }

    @Override
    public boolean login(String loginId, String password) {
       List<UserEntity> user = userEntityDao.findByLoginIdAndPassword(loginId, password);
       return user.isEmpty()?false:true;
    }
}
