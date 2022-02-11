package com.example.server.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class GwcGood implements Serializable {
    //主键
    private Integer id;
//    //总价
//    private String totalValue;

    private String num;

    private Integer goodid;

    private Integer userId;

    private String image;

    private String title;

    private String price;


}
