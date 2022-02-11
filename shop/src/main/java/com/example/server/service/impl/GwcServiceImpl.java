package com.example.server.service.impl;

import com.example.server.entity.Good;
import com.example.server.repository.GwcRepository;
import com.example.server.service.GwcService;
import com.example.server.entity.Gwc;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;
import java.util.Optional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
@author Tison
*/
@Service
public class GwcServiceImpl  implements GwcService  {

	@Resource
	private GwcRepository rep;


	 public Gwc save(Gwc obj) {
		 return rep.save(obj);
	 }


	 @Transactional
	 public List<Gwc> saveAll(Iterable<Gwc> list) {
		 return rep.saveAll(list);
	 }


	 public Gwc getOne(Integer id) {
		 return rep.getOne(id);
	 }


	 public Gwc findById(Integer id) {
		 Optional<Gwc> obj = rep.findById(id);
		 return obj.isPresent()?obj.get():null;
	 }


	 public void deleteById(Integer id) {
		 rep.deleteById(id);
	 }


	 @Transactional
	 public void deleteAll(List list) {
		 rep.deleteAll(list);
	 }


	 public void delete(Gwc obj) {
		 rep.delete(obj);
	 }


	 public boolean existsById(Integer id) {
		 return rep.existsById(id);
	 }


	 public long count() {
		 return rep.count();
	 }


	 public List<Gwc> findAll() {
		 return rep.findAll();
	 }


	 public List<Gwc> findAll(Gwc obj) {
		 List<Gwc> list = rep.findAll(Example.of(obj));
		 return list==null||list.size()<1?null:list;
	 }


	 public List<Gwc> findAll(Sort sort) {
		 return rep.findAll(sort);
	 }


	 public List<Gwc> findAllById(Iterable<Integer> ids) {
		 return rep.findAllById(ids);
	 }


	 public List<Gwc> findAll(Example<Gwc> e) {
		 return rep.findAll(e);
	 }


	 public List<Gwc> findAll(Example<Gwc> e, Sort sort) {
		 return rep.findAll(e,sort);
	 }


	 public Page<Gwc> findAll(Pageable page) {
		 return rep.findAll(page);
	 }


	 public Page<Gwc> findAll(Example<Gwc> e, Pageable page) {
		 return rep.findAll(e,page);
	 }


	 public Page<Gwc> findAll(Gwc obj, Pageable page) {
		 return rep.findAll(Example.of(obj),page);
	 }
	public List<Gwc> findAllByGoodIdAndUserId(int goodId, int userId) {
		List<Gwc> list = rep.findAllByGoodidAndUserId(goodId,userId);
		return list==null||list.size()<1?null:list;
	}

}
