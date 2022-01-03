package com.xiaobai.store.controller;

import com.xiaobai.store.service.ICartServices;
import com.xiaobai.store.util.JsonResult;
import com.xiaobai.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车的控制层
 * @author xiaobaicai
 * data:2021-12-31
 */

@RequestMapping("carts")
@RestController
public class CartController extends BaseController{
    @Autowired
    private ICartServices cartServices;

    @RequestMapping("add_to_cart")
    JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        cartServices.addToCart(uid, pid, amount, username);
        return new JsonResult<>(OK);
    }

    @RequestMapping({"/",""})
    JsonResult<List<CartVO>> getVOByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<CartVO> list = cartServices.getVOByUid(uid);
        return new JsonResult<>(OK, list);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行增加数量
        Integer data = cartServices.addNum(cid, uid, username);
        // 返回成功
        return new JsonResult<Integer>(OK, data);
    }

    @RequestMapping("{cid}/num/reduce")
    public JsonResult<Integer> reduceNum(@PathVariable("cid") Integer cid, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行增加数量
        Integer data = cartServices.reduceNum(cid, uid, username);
        // 返回成功
        return new JsonResult<Integer>(OK, data);
    }

    @RequestMapping("list")
    public JsonResult<List<CartVO>> getVOByCid(Integer[] cids, HttpSession session){
        Integer uid = getUidFromSession(session);
        List<CartVO> list = cartServices.findCartVoByCid(cids, uid);
        return new JsonResult<>(OK, list);
    }
}
