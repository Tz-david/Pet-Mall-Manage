package com.example.server.repository;

import com.example.server.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
@author Tison
*/
public interface GoodRepository extends JpaRepository<Good, Integer>, GoodRepositoryCustom {
    List<Good> findByRecommend(String recommend);
}
