package com.example.server.repository.impl;

import com.example.server.repository.GwcRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
@author Tison
*/
@Repository
public class GwcRepositoryImpl implements GwcRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
