package com.example.server.repository;

import com.example.server.entity.UserManage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
@author Tison
*/
public interface UserManageRepository extends JpaRepository<UserManage, Integer>, UserManageRepositoryCustom {
    List<UserManage> findByUsernameAndPassword(String username, String password);
    List<UserManage> findByOpenid(String openid);
}
