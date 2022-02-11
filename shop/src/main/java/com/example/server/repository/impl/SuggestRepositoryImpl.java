package com.example.server.repository.impl;

import com.example.server.repository.SuggestRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
@author Tison
*/
@Repository
public class SuggestRepositoryImpl implements SuggestRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
