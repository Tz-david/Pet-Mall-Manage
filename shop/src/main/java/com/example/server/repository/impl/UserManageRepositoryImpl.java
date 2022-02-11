package com.example.server.repository.impl;

import com.example.server.repository.UserManageRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
@author Tison
*/
@Repository
public class UserManageRepositoryImpl implements UserManageRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
