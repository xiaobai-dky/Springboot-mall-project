package com.xiaobai.store.mapper;

import com.xiaobai.store.entity.Cart;
import com.xiaobai.store.vo.CartVO;

import java.util.Date;
import java.util.List;

/**
 * 购物车持久层接口
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface CartMapper {
    /**
     * 根据购物车数据插入到数据库里面
     * @param cart 用户购物车数据
     * @return 影响的行数
     */
    Integer insert(Cart cart);

    /**
     * 通过cid 更新购物车的数据
     * @param cid 购物车的cid
     * @param num 更新数据库中的数据
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 影响的行数
     */
    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    /**
     * 根据id查询购物车的数据
     * @param pid 商品的id
     * @param uid 用户的id
     * @return 购物车的数据
     */
    Cart findCartById(Integer pid, Integer uid);

    /**
     * 通过用户的id查到所属的所有购物清单
     * @param uid 用户uid
     * @return 多表联查的VO类
     */
    List<CartVO> findCartVoByUid(Integer uid);


    /**
     * 通过商品的cid查找该条商品记录
     * @param cid 商品的cid
     * @return 购物车
     */
    Cart findCartByCid(Integer cid);

    /**
     * 通过选中的的cid查到所属的所有购物清单
     * @param cids 商品号cid集合
     * @return 多表联查的VO类
     */
    List<CartVO> findCartVoByCid(Integer[] cids);
}
