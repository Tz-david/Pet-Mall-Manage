package com.example.server.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderLitItem {
    //主键
    private Integer id;

    private Integer totalPrice;

    private String time;

    private String state;

    private List<OrderGood> goodsList;


}
