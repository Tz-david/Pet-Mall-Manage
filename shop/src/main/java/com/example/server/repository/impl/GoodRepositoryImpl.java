package com.example.server.repository.impl;

import com.example.server.repository.GoodRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
@author Tison
*/
@Repository
public class GoodRepositoryImpl implements GoodRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
