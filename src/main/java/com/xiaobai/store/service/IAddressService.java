package com.xiaobai.store.service;

import com.xiaobai.store.entity.Address;

import java.util.List;

/**
 * 地址模块业务层接口
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface IAddressService {
    /**
     * 插入新的address
     * @param uid 用户的uid
     * @param username 用户名
     * @param address 用户的表单提交的address对象
     */
    void addNewAddress(Integer uid, String username, Address address);

    /**
     * 根据用户的uid得到相应的收货地址
     * @param uid 用户uid
     * @return 用户的地址顺序
     */
    List<Address> getByUid(Integer uid);

    /**
     * 设置默认地址为选中的aid
     * @param aid 选中地址的aid
     * @param uid 该用户的uid
     * @param username 该用户
     */
    void setDefault(Integer aid, Integer uid, String username);

    /**
     * 删除完地址后默认地址设置为最新修改的
     * @param aid 用户的aid
     * @param uid 用户的uid
     * @param username 用户名
     */
    void delete(Integer aid, Integer uid, String username);

    /**
     * 根据aid和用户的uid查询地址
     * @param aid 地址的aid
     * @param uid 用户的uid
     * @return Address地址
     */
    Address getByAid(Integer aid, Integer uid);
}
