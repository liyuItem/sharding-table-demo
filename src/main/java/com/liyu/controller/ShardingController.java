package com.liyu.controller;

import com.liyu.dao.OrderMapper;
import com.liyu.entity.Order;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
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
        for(long i=0;i<100;i++) {
            Order order = new Order();
            order.setStatus("1");
            order.setUserId(1);
            orderMapper.insert(order);
        }
    }
}
