package com.webonise.login.dao;

import com.webonise.login.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long> {

    UserEntity findByLoginIdAndPassword(String loginId, String password);

    UserEntity findByLoginId(String loginId);
}
