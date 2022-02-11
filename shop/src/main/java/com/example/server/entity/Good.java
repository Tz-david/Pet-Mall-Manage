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
@Table(name = "good")
public class Good implements Serializable {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@Column(name = "id", nullable = false, length = 11)
	private Integer id;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "title", nullable = false, length = 255)
	private String title;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "image", nullable = false, length = 255)
	private String image;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "image2", nullable = false, length = 255)
	private String image2;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "image3", nullable = false, length = 255)
	private String image3;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "price", nullable = false, length = 255)
	private String price;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "sales", nullable = false, length = 10000)
	private String sales;

	/**
	 * null
	 * default value: '0'
	 */
	@Column(name = "click_num", nullable = false, length = 255)
	private String clicknum;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "good_number", nullable = false, length = 255)
	private String goodnumber;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "sell_number", nullable = false, length = 255)
	private String sellnumber;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "content", nullable = false, length = 1000)
	private String content;

	/**
	 * null
	 * default value: 'false'
	 */
	@Column(name = "recommend", nullable = false, length = 255)
	private String recommend;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "type", nullable = false, length = 255)
	private String type;
}
