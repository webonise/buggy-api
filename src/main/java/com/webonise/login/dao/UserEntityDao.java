package com.webonise.login.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webonise.login.model.UserEntity;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long> {
    
    @Query(value = "SELECT a FROM UserEntity a WHERE loginId = ?1 AND password = ?2 GROUP BY loginId")
    UserEntity findByLoginIdAndPassword(String loginId, String password);
    
    List<UserEntity> findByLoginId(String loginId);
}
