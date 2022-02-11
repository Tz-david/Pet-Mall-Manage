package com.example.server.service.impl;

import com.example.server.repository.UserManageRepository;
import com.example.server.service.UserManageService;
import com.example.server.entity.UserManage;
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
public class UserManageServiceImpl  implements UserManageService  {

	@Resource
	private UserManageRepository rep;


	 public UserManage save(UserManage obj) {
		 return rep.save(obj);
	 }


	 @Transactional
	 public List<UserManage> saveAll(Iterable<UserManage> list) {
		 return rep.saveAll(list);
	 }


	 public UserManage getOne(Integer id) {
		 return rep.getOne(id);
	 }


	 public UserManage findById(Integer id) {
		 Optional<UserManage> obj = rep.findById(id);
		 return obj.isPresent()?obj.get():null;
	 }


	 public void deleteById(Integer id) {
		 rep.deleteById(id);
	 }


	 @Transactional
	 public void deleteAll(List list) {
		 rep.deleteAll(list);
	 }


	 public void delete(UserManage obj) {
		 rep.delete(obj);
	 }


	 public boolean existsById(Integer id) {
		 return rep.existsById(id);
	 }


	 public long count() {
		 return rep.count();
	 }


	 public List<UserManage> findAll() {
		 return rep.findAll();
	 }


	 public List<UserManage> findAll(UserManage obj) {
		 List<UserManage> list = rep.findAll(Example.of(obj));
		 return list==null||list.size()<1?null:list;
	 }


	 public List<UserManage> findAll(Sort sort) {
		 return rep.findAll(sort);
	 }


	 public List<UserManage> findAllById(Iterable<Integer> ids) {
		 return rep.findAllById(ids);
	 }


	 public List<UserManage> findAll(Example<UserManage> e) {
		 return rep.findAll(e);
	 }


	 public List<UserManage> findAll(Example<UserManage> e, Sort sort) {
		 return rep.findAll(e,sort);
	 }


	 public Page<UserManage> findAll(Pageable page) {
		 return rep.findAll(page);
	 }


	 public Page<UserManage> findAll(Example<UserManage> e, Pageable page) {
		 return rep.findAll(e,page);
	 }


	 public Page<UserManage> findAll(UserManage obj, Pageable page) {
		 return rep.findAll(Example.of(obj),page);
	 }

	public List<UserManage> findAllByUsernameAndPassword(String username, String password) {
		return rep.findByUsernameAndPassword(username, password);
	}

	public List<UserManage> findAllByOpenid(String openid) {
		return rep.findByOpenid(openid);
	}
}
