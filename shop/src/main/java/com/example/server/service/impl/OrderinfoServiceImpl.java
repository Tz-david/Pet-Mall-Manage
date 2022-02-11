package com.example.server.service.impl;

import com.example.server.repository.OrderinfoRepository;
import com.example.server.service.OrderinfoService;
import com.example.server.entity.Orderinfo;
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
public class OrderinfoServiceImpl  implements OrderinfoService  {

	@Resource
	private OrderinfoRepository rep;


	 public Orderinfo save(Orderinfo obj) {
		 return rep.save(obj);
	 }


	 @Transactional
	 public List<Orderinfo> saveAll(Iterable<Orderinfo> list) {
		 return rep.saveAll(list);
	 }


	 public Orderinfo getOne(Integer id) {
		 return rep.getOne(id);
	 }


	 public Orderinfo findById(Integer id) {
		 Optional<Orderinfo> obj = rep.findById(id);
		 return obj.isPresent()?obj.get():null;
	 }


	 public void deleteById(Integer id) {
		 rep.deleteById(id);
	 }


	 @Transactional
	 public void deleteAll(List list) {
		 rep.deleteAll(list);
	 }


	 public void delete(Orderinfo obj) {
		 rep.delete(obj);
	 }


	 public boolean existsById(Integer id) {
		 return rep.existsById(id);
	 }


	 public long count() {
		 return rep.count();
	 }


	 public List<Orderinfo> findAll() {
		 return rep.findAll();
	 }


	 public List<Orderinfo> findAll(Orderinfo obj) {
		 List<Orderinfo> list = rep.findAll(Example.of(obj));
		 return list==null||list.size()<1?null:list;
	 }


	 public List<Orderinfo> findAll(Sort sort) {
		 return rep.findAll(sort);
	 }


	 public List<Orderinfo> findAllById(Iterable<Integer> ids) {
		 return rep.findAllById(ids);
	 }


	 public List<Orderinfo> findAll(Example<Orderinfo> e) {
		 return rep.findAll(e);
	 }


	 public List<Orderinfo> findAll(Example<Orderinfo> e, Sort sort) {
		 return rep.findAll(e,sort);
	 }


	 public Page<Orderinfo> findAll(Pageable page) {
		 return rep.findAll(page);
	 }


	 public Page<Orderinfo> findAll(Example<Orderinfo> e, Pageable page) {
		 return rep.findAll(e,page);
	 }


	 public Page<Orderinfo> findAll(Orderinfo obj, Pageable page) {
		 return rep.findAll(Example.of(obj),page);
	 }


}
