package com.xiaobai.store.service;

import com.xiaobai.store.entity.Order;
import com.xiaobai.store.entity.OrderItem;
import com.xiaobai.store.vo.OrderVO;

import java.util.List;

/**
 * 处理订单和订单数据的业务层接口
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface IOrderService {
    /**
     * 创建订单
     * @param aid 收货地址的id
     * @param cids 即将购买的商品数据在购物车表中的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 成功创建的订单数据
     */
    Order create(Integer aid, Integer[] cids, Integer uid, String username);

    /**
     * 通过用户的uid找到用户所有订单的oid
     * @param uid 用户的uid
     * @return 用户所有订单的oid
     */
    List<Order> findOrdersByUid(Integer uid);

    /**
     * 通过用户订单的oid找到该订单的全部内容
     * @param oid 用户订单的oid
     * @return 订单详细的列表
     */
    List<OrderItem> findOrderItemsByOid(Integer oid);
}
