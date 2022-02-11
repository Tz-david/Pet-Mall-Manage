package com.example.server.repository.impl;

import com.example.server.repository.OrderinfoRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
@author Tison
*/
@Repository
public class OrderinfoRepositoryImpl implements OrderinfoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
