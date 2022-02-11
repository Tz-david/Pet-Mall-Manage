package com.example.server.service.impl;

import com.example.server.repository.GoodRepository;
import com.example.server.service.GoodService;
import com.example.server.entity.Good;
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
public class GoodServiceImpl  implements GoodService  {

	@Resource
	private GoodRepository rep;


	 public Good save(Good obj) {
		 return rep.save(obj);
	 }


	 @Transactional
	 public List<Good> saveAll(Iterable<Good> list) {
		 return rep.saveAll(list);
	 }


	 public Good getOne(Integer id) {
		 return rep.getOne(id);
	 }


	 public Good findById(Integer id) {
		 Optional<Good> obj = rep.findById(id);
		 return obj.isPresent()?obj.get():null;
	 }


	 public void deleteById(Integer id) {
		 rep.deleteById(id);
	 }


	 @Transactional
	 public void deleteAll(List list) {
		 rep.deleteAll(list);
	 }


	 public void delete(Good obj) {
		 rep.delete(obj);
	 }


	 public boolean existsById(Integer id) {
		 return rep.existsById(id);
	 }


	 public long count() {
		 return rep.count();
	 }


	 public List<Good> findAll() {
		 return rep.findAll();
	 }


	 public List<Good> findAll(Good obj) {
		 List<Good> list = rep.findAll(Example.of(obj));
		 return list==null||list.size()<1?null:list;
	 }


	 public List<Good> findAll(Sort sort) {
		 return rep.findAll(sort);
	 }


	 public List<Good> findAllById(Iterable<Integer> ids) {
		 return rep.findAllById(ids);
	 }


	 public List<Good> findAll(Example<Good> e) {
		 return rep.findAll(e);
	 }


	 public List<Good> findAll(Example<Good> e, Sort sort) {
		 return rep.findAll(e,sort);
	 }


	 public Page<Good> findAll(Pageable page) {
		 return rep.findAll(page);
	 }


	 public Page<Good> findAll(Example<Good> e, Pageable page) {
		 return rep.findAll(e,page);
	 }


	 public Page<Good> findAll(Good obj, Pageable page) {
		 return rep.findAll(Example.of(obj),page);
	 }

	public List<Good> findAllRecommend(String recommend) {
		return rep.findByRecommend(recommend);
	}
}
