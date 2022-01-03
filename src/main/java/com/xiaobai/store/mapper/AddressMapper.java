package com.xiaobai.store.mapper;

import com.xiaobai.store.entity.Address;

import java.util.Date;
import java.util.List;

/**
 * 收获地址持久层接口
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface AddressMapper {
    /**
     * 插入一条用户新的收货地址
     * @param address 地址类
     * @return 返回影响的行数
     */
    Integer insert(Address address);

    /**
     * 统计一个用户收货地址条数
     * @param uid 用户的uid
     * @return 收获地址条数
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户uid查询所有收货地址
     * @param uid 用户的uid
     * @return 地址信息
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据记录的aid查询该条记录
     * @param aid 该条记录的aid
     * @return 返回该条记录
     */
    Address findByAid(Integer aid);

    /**
     * 根据用户id将所有的收货地址设置为非默认
     * @param uid 用户的uid
     * @return 受影响的行数
     */
    Integer updateNoDefault(Integer uid);

    /**
     * 修改选中收货地址为默认收货地址
     * @param aid 选中记录的aid
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateDefault(Integer aid, String modifiedUser, Date modifiedTime);


    /**
     * 根据用户aid删除地址
     * @param aid 用户的aid
     * @return 受影响的行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据用户的uid查找到最后一条修改的记录
     * @param uid 用户的uid
     * @return 该条记录
     */
    Address findLastModified(Integer uid);
}
