package com.webonise.login.dao;

import com.webonise.login.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long> {
    
    @Query(value = "SELECT a FROM UserEntity a WHERE loginId = ?1 AND password = ?2 GROUP BY loginId")
    UserEntity findByLoginIdAndPassword(String loginId, String password);
}
