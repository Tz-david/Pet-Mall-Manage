package com.example.server.repository;

import com.example.server.entity.Suggest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
@author Tison
*/
public interface SuggestRepository extends JpaRepository<Suggest, Integer>, SuggestRepositoryCustom {

}
