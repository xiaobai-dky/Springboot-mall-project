package com.xiaobai.store.service;

import com.xiaobai.store.entity.Cart;
import com.xiaobai.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 购物车的业务层
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface ICartServices {
    /**
     * 将商品添加到购物车
     * @param uid 当前登录用户的id
     * @param pid 商品的id
     * @param amount 增加的数量
     * @param username 当前登录的用户名
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVO> getVOByUid(Integer uid);




    /**
     * 通过购物车的cid获取该条购物清单
     * @param cid 购物车的cid
     * @param uid 用户的uid
     * @param username 添加该条记录的username
     * @return 返回添加后信息的数量
     */
    Integer addNum(Integer cid, Integer uid, String username);

    /**
     * 通过购物车的cid获取该条购物清单
     * @param cid 购物车的cid
     * @param uid 用户的uid
     * @param username 添加该条记录的username
     * @return 返回添加后信息的数量
     */
    Integer reduceNum(Integer cid, Integer uid, String username);


    /**
     * 通过选中的的cid查到所属的所有购物清单
     * @param cids 商品号cid集合
     * @param uid  用户的uid
     * @return 多表联查的VO类
     */
    List<CartVO> findCartVoByCid(Integer[] cids, Integer uid);
}
