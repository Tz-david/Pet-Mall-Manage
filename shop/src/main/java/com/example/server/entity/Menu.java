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
@Table(name = "menu")
public class Menu implements Serializable {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@Column(name = "id", nullable = false, length = 11)
	private Integer id;

	/**
	 * null
	 * default value: ''
	 */
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "pid", nullable = true, length = 255)
	private Integer pid;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "picture", nullable = true, length = 255)
	private String picture;
}
