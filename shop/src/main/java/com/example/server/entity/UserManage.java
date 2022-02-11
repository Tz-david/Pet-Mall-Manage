package com.example.server.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Tison
 * null
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "user_manage")
public class UserManage implements Serializable {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 11)
	private Integer id;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "username", nullable = false, length = 255)
	private String username;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "password", nullable = false, length = 255)
	private String password;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "photo", nullable = false, length = 255)
	private String photo;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "age", nullable = false, length = 11)
	private Integer age;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "sex", nullable = false, length = 255)
	private String sex;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "phone", nullable = false, length = 255)
	private String phone;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "descripiton", nullable = false, length = 255)
	private String descripiton;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "role", nullable = false, length = 255)
	private String role;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "openid", nullable = false, length = 255)
	private String openid;
}
