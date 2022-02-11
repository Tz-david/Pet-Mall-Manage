package com.example.server.repository;

import com.example.server.entity.Gwc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
@author Tison
*/
public interface GwcRepository extends JpaRepository<Gwc, Integer>, GwcRepositoryCustom {
    List<Gwc> findAllByGoodidAndUserId(int goodId, int userId);
}
