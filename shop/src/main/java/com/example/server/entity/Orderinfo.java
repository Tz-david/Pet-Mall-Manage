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
@Table(name = "orderinfo")
public class Orderinfo implements Serializable {

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
	@Column(name = "user_id", nullable = false, length = 255)
	private Integer userId;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "good_id", nullable = false, length = 255)
	private Integer goodId;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "state", nullable = false, length = 255)
	private String state;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "order_id", nullable = false, length = 255)
	private String orderId;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "num", nullable = false, length = 255)
	private Integer num;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "time", nullable = false, length = 255)
	private String time;
}
