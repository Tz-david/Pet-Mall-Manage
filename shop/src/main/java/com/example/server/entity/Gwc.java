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
@Table(name = "gwc")
public class Gwc implements Serializable {

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
	@Column(name = "value", nullable = false, length = 225)
	private String value;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "goodid", nullable = false, length = 11)
	private Integer goodid;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "num", nullable = false, length = 255)
	private String num;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "user_id", nullable = false, length = 255)
	private Integer userId;
}
