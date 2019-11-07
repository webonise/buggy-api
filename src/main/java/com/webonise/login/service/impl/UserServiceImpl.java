package com.webonise.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.login.dao.UserEntityDao;
import com.webonise.login.exception.NoUniqueUserFoundException;
import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserEntity;
import com.webonise.login.model.UserRequest;
import com.webonise.login.service.UserService;

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
	public boolean login(String loginId, String password) throws NoUniqueUserFoundException {
		UserEntity user[] = userEntityDao.findByLoginIdAndPassword(loginId, password);
		UserEntity loggedInUser = findUniqueUserRecord(user);
		return loggedInUser != null;
	}

	private UserEntity findUniqueUserRecord(UserEntity[] user) throws NoUniqueUserFoundException {
		if (user.length > 1) {
			throw new NoUniqueUserFoundException(
					"Could not find a Unique User record with login Id : " + user[0].getLoginId());
		}else {
			return user[0];
		}
	}
}
