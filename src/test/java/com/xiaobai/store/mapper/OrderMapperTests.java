package com.xiaobai.store.mapper;

import com.xiaobai.store.entity.Order;
import com.xiaobai.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTests {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void findOrdersByUid(){
        List<Order> res = orderMapper.findOrdersByUid(14);
        System.out.println(res);
    }

    @Test
    public void findOrderItemsByOid(){
        List<OrderItem> res = orderMapper.findOrderItemsByOid(4);
        for (OrderItem orderItem : res){
            System.out.println(orderItem);
        }
    }


}
