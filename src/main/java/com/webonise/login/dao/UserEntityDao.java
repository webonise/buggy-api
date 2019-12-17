package com.webonise.login.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webonise.login.model.UserEntity;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long> {
	
	

    List<UserEntity> findByLoginIdAndPassword(String loginId, String password);
}
