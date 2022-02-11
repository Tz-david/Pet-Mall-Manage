package com.example.server.entity;

import lombok.Data;

@Data
public class OrderGood {
    //主键
    private Integer id;

    private Integer num;

    private Integer goodId;

    private Integer userId;

    private String time;

    private String title;

    private String price;

    private String image;

    private String state;

    private String orderId;

}
