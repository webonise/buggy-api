package com.webonise.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webonise.login.model.UserEntity;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long> {

    UserEntity[] findByLoginIdAndPassword(String loginId, String password);
}
