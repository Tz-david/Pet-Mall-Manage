package com.example.server.service.impl;

import com.example.server.repository.SuggestRepository;
import com.example.server.service.SuggestService;
import com.example.server.entity.Suggest;
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
public class SuggestServiceImpl  implements SuggestService  {

	@Resource
	private SuggestRepository rep;


	 public Suggest save(Suggest obj) {
		 return rep.save(obj);
	 }


	 @Transactional
	 public List<Suggest> saveAll(Iterable<Suggest> list) {
		 return rep.saveAll(list);
	 }


	 public Suggest getOne(Integer id) {
		 return rep.getOne(id);
	 }


	 public Suggest findById(Integer id) {
		 Optional<Suggest> obj = rep.findById(id);
		 return obj.isPresent()?obj.get():null;
	 }


	 public void deleteById(Integer id) {
		 rep.deleteById(id);
	 }


	 @Transactional
	 public void deleteAll(List list) {
		 rep.deleteAll(list);
	 }


	 public void delete(Suggest obj) {
		 rep.delete(obj);
	 }


	 public boolean existsById(Integer id) {
		 return rep.existsById(id);
	 }


	 public long count() {
		 return rep.count();
	 }


	 public List<Suggest> findAll() {
		 return rep.findAll();
	 }


	 public List<Suggest> findAll(Suggest obj) {
		 List<Suggest> list = rep.findAll(Example.of(obj));
		 return list==null||list.size()<1?null:list;
	 }


	 public List<Suggest> findAll(Sort sort) {
		 return rep.findAll(sort);
	 }


	 public List<Suggest> findAllById(Iterable<Integer> ids) {
		 return rep.findAllById(ids);
	 }


	 public List<Suggest> findAll(Example<Suggest> e) {
		 return rep.findAll(e);
	 }


	 public List<Suggest> findAll(Example<Suggest> e, Sort sort) {
		 return rep.findAll(e,sort);
	 }


	 public Page<Suggest> findAll(Pageable page) {
		 return rep.findAll(page);
	 }


	 public Page<Suggest> findAll(Example<Suggest> e, Pageable page) {
		 return rep.findAll(e,page);
	 }


	 public Page<Suggest> findAll(Suggest obj, Pageable page) {
		 return rep.findAll(Example.of(obj),page);
	 }


}
