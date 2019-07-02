package com.liyu.controller;

import com.liyu.dao.OrderMapper;
import com.liyu.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyu
 * @date:2019/7/1
 * @describe:
 */
@RestController
public class ShardingController {

    @Autowired
    OrderMapper orderMapper;

    @GetMapping("/v1/get")
    public void test() {
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            order.setStatus("1");
            order.setUserId(i);
            orderMapper.addOrder(order);
        }
    }

    @GetMapping("/v1/get/v1")
    public void test1() {
        Order order = orderMapper.selectByPrimaryKey(1L);
        System.out.println(order.getUserId());
    }
}
