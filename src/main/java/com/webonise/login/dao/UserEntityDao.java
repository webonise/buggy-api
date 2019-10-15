package com.webonise.login.dao;

import com.webonise.login.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long> {

    UserEntity findByLoginId(String loginId);
    UserEntity findByLoginIdAndPassword(String loginId, String password);
}
