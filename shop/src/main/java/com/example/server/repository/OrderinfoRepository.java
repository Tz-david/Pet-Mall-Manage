package com.example.server.repository;

import com.example.server.entity.Orderinfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
@author Tison
*/
public interface OrderinfoRepository extends JpaRepository<Orderinfo, Integer>, OrderinfoRepositoryCustom {

}
