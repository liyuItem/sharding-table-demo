package com.liyu.entity;

import lombok.Data;

@Data
public class Order {

    private Long orderId;

    private Integer userId;

    private String status;

}