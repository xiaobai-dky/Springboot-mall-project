package com.xiaobai.store.service.impl;

import com.xiaobai.store.entity.Cart;
import com.xiaobai.store.entity.Product;
import com.xiaobai.store.mapper.CartMapper;
import com.xiaobai.store.service.ICartServices;
import com.xiaobai.store.service.IProductService;
import com.xiaobai.store.service.ex.*;
import com.xiaobai.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 购物车业务层的实现类
 * @author xiaobaicai
 * data:2021-12-31
 */

@Service
public class CartServicesImpl implements ICartServices {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private IProductService productService;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        // 根据参数pid和uid查询购物车中的数据
        if (uid == null){
            throw new UserNotFoundException("用户未找到,您可能需要登录");
        }
        Cart result = cartMapper.findCartById(pid, uid);
        Date now = new Date();
        // 判断查询结果是否为null
        if (result == null) {
            // 是：表示该用户并未将该商品添加到购物车
            // 创建Cart对象
            Cart cart = new Cart();
            // 封装数据：uid,pid,amount
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            // 调用productService.findById(pid)查询商品数据，得到商品价格
            Product product = productService.findById(pid);
            // 封装数据：price
            cart.setPrice(product.getPrice());
            // 封装数据：4个日志
            cart.setCreatedUser(username);
            cart.setCreatedTime(now);
            cart.setModifiedUser(username);
            cart.setModifiedTime(now);

            // 调用insert(cart)执行将数据插入到数据表中
            Integer rows = cartMapper.insert(cart);
            if (rows != 1) {
                throw new InsertException("插入商品数据时出现未知错误，请联系系统管理员");
            }
        } else {
            // 否：表示该用户的购物车中已有该商品
            // 从查询结果中获取购物车数据的id
            Integer cid = result.getCid();
            // 从查询结果中取出原数量，与参数amount相加，得到新的数量
            Integer num = result.getNum() + amount;
            // 执行更新数量
            Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
            if (rows != 1) {
                throw new InsertException("添加商品数量时出现未知错误，请联系系统管理员");
            }
        }
    }

    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findCartVoByUid(uid);
    }



    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findCartByCid(cid);
        if (result == null){
            throw new CartNotFoundException("该条购物清单不存在!");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = result.getNum() + 1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (rows != 1){
            throw new UpdateException("数据更新失败");
        }
        return num;
    }

    @Override
    public Integer reduceNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findCartByCid(cid);
        if (result == null){
            throw new CartNotFoundException("该条购物清单不存在!");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = result.getNum() - 1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (rows != 1){
            throw new UpdateException("数据更新失败");
        }
        return num;
    }

    @Override
    public List<CartVO> findCartVoByCid(Integer[] cids, Integer uid) {
        List<CartVO> list = cartMapper.findCartVoByCid(cids);
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()){
            CartVO cartVO = it.next();
            if (!cartVO.getUid().equals(uid)){
                list.remove(cartVO);
            }
        }
        return list;
    }
}
