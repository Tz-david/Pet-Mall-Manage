package com.example.server.service.impl;

import com.example.server.repository.MenuRepository;
import com.example.server.service.MenuService;
import com.example.server.entity.Menu;
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
public class MenuServiceImpl  implements MenuService  {

	@Resource
	private MenuRepository rep;


	 public Menu save(Menu obj) {
		 return rep.save(obj);
	 }


	 @Transactional
	 public List<Menu> saveAll(Iterable<Menu> list) {
		 return rep.saveAll(list);
	 }


	 public Menu getOne(Integer id) {
		 return rep.getOne(id);
	 }


	 public Menu findById(Integer id) {
		 Optional<Menu> obj = rep.findById(id);
		 return obj.isPresent()?obj.get():null;
	 }


	 public void deleteById(Integer id) {
		 rep.deleteById(id);
	 }


	 @Transactional
	 public void deleteAll(List list) {
		 rep.deleteAll(list);
	 }


	 public void delete(Menu obj) {
		 rep.delete(obj);
	 }


	 public boolean existsById(Integer id) {
		 return rep.existsById(id);
	 }


	 public long count() {
		 return rep.count();
	 }


	 public List<Menu> findAll() {
		 return rep.findAll();
	 }


	 public List<Menu> findAll(Menu obj) {
		 List<Menu> list = rep.findAll(Example.of(obj));
		 return list==null||list.size()<1?null:list;
	 }


	 public List<Menu> findAll(Sort sort) {
		 return rep.findAll(sort);
	 }


	 public List<Menu> findAllById(Iterable<Integer> ids) {
		 return rep.findAllById(ids);
	 }


	 public List<Menu> findAll(Example<Menu> e) {
		 return rep.findAll(e);
	 }


	 public List<Menu> findAll(Example<Menu> e, Sort sort) {
		 return rep.findAll(e,sort);
	 }


	 public Page<Menu> findAll(Pageable page) {
		 return rep.findAll(page);
	 }


	 public Page<Menu> findAll(Example<Menu> e, Pageable page) {
		 return rep.findAll(e,page);
	 }


	 public Page<Menu> findAll(Menu obj, Pageable page) {
		 return rep.findAll(Example.of(obj),page);
	 }


}
