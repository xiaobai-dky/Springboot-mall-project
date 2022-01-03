package com.xiaobai.store.controller;

import com.xiaobai.store.entity.Order;
import com.xiaobai.store.entity.OrderItem;
import com.xiaobai.store.service.IOrderService;
import com.xiaobai.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 订单控制层
 * @author xiaobaicai
 * data:2021-12-31
 */

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController{
    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行业务
        Order data = orderService.create(aid, cids, uid, username);
        // 返回成功与数据
        return new JsonResult<Order>(OK, data);
    }
    @RequestMapping("showOrders")
    public JsonResult<List<Order>> getOrdersByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Order> date = orderService.findOrdersByUid(uid);
        return new JsonResult<List<Order>>(OK, date);
    }
    @RequestMapping("showOrderItems")
    public JsonResult<List<OrderItem>> getOrderItemsByUid(Integer oid){
        List<OrderItem> date = orderService.findOrderItemsByOid(oid);
        return new JsonResult<List<OrderItem>>(OK, date);
    }
}
