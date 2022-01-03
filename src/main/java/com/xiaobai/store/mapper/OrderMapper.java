package com.xiaobai.store.mapper;

import com.xiaobai.store.entity.Order;
import com.xiaobai.store.entity.OrderItem;
import com.xiaobai.store.vo.OrderVO;

import java.util.List;

/**
 * 订单项的持久层
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单项数据
     * @param orderItem 订单数据
     * @return 影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);


    /**
     * 通过用户的uid找到订单
     * @param uid 用户的uid
     * @return 用户订单的全部
     */
    List<Order> findOrdersByUid(Integer uid);

    /**
     * 通过用户订单的oid找到该订单的全部内容
     * @param oid 用户订单的oid
     * @return 订单详细的列表
     */
    List<OrderItem> findOrderItemsByOid(Integer oid);
}
