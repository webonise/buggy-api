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
        //UserEntity userEntity = userEntityDao.save(new UserEntity(userRequest));
        //return new UserDTO(userEntity);
    	
    	UserEntity user = null;
    	
    	try {
    		user = userEntityDao.findByLoginId(userRequest.getLoginId());
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	
    	if(user != null){
    		throw new RuntimeException("This LoginId has already Used");
    	}
    	else {
    		return new UserDTO(userEntityDao.save(new UserEntity(userRequest)));
    	}
        
    }

    @Override
    public boolean login(String loginId, String password) {
		List<UserEntity> user = userEntityDao.findByLoginIdAndPassword(loginId, password);
		return user != null && user.size() > 0;
		
		
		/*
		 The user who is not able to login has two entries in user table, we were just acepting only single entry while fetching the user and it was giving more than one entry, This scenario can be 
handle by limiting in JpaRepository or writing our on query to fetch user and senond way is accept the data in list format (if list size is more than one then user is exit in database
with given credential).
		 */
    }
}
