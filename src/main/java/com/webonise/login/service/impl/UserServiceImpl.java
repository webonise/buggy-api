package com.webonise.login.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.login.dao.UserEntityDao;
import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserEntity;
import com.webonise.login.model.UserRequest;
import com.webonise.login.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserEntityDao userEntityDao;

	@Override
	public UserDTO saveUser(UserRequest userRequest) throws Exception {

		UserEntity userEntity = userEntityDao.findByLoginId(userRequest.getLoginId());

		if (Objects.nonNull(userEntity)) {
			throw new Exception("Login Id '" + userRequest.getLoginId() + "' is already registered.");
		} else {
			System.out.println("User loginId = " + userRequest.getLoginId());
			userEntity = userEntityDao.save(new UserEntity(userRequest));
		}

		UserDTO userDTO = new UserDTO(userEntity);

		return userDTO;
	}

	@Override
	public boolean login(String loginId, String password) throws Exception {
		UserEntity user = userEntityDao.findByLoginIdAndPassword(loginId, password);
		if (Objects.isNull(user)) {
			throw new Exception("Bad login credentials");
		}
		return user != null;
	}
}