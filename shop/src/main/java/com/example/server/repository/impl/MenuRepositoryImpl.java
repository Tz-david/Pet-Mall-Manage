package com.example.server.repository.impl;

import com.example.server.repository.MenuRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
@author Tison
*/
@Repository
public class MenuRepositoryImpl implements MenuRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
