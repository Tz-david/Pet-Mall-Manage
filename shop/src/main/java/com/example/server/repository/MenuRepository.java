package com.example.server.repository;

import com.example.server.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
@author Tison
*/
public interface MenuRepository extends JpaRepository<Menu, Integer>, MenuRepositoryCustom {

}
