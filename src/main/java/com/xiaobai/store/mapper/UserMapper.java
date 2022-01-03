package com.xiaobai.store.mapper;

import com.xiaobai.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 用户模块的持久层接口
 * @author xiaobaicai
 * data:2021-12-31
 */
public interface UserMapper {
    /**
     * 注册一个用户
     * @param user 参数为用户
     * @return 返回值为影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户的名字判断是否数据库中是否有重复数值
     * @param userName 用户输入框中的名字
     * @return 找到返回的该名字的对象，没找到返回null
     */
    User findByUsername(String userName);

    /**
     * 通过存储再浏览器中的uid值进行对密码的修改操作
     * @param uid session中的uid
     * @param password 用户想要修改的密码
     * @param modifiedUser 修改的人员
     * @param modifiedTime 修改的时间
     * @return 返回修改影响的行数
     */
    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);

    /**
     * 通过存储再浏览器中的uid值查找该用户是否存在或者被删除
     * @param uid session中的uid
     * @return 找到就返回该用户对象
     */
    User findByUid(Integer uid);

    /**
     * 通过用户提交的数据实现对用户的信息进行修改
     * @param user 用户修改的参数通过表单提交过来成一个对象
     * @return 修改影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * 通过用户提交的头像实现对用户的头像进行修改
     * @param uid 用户的uid 加上@Param("#{SQL映射文件中的}")，就是为了防止参数名与数据库名称占位符名称不一致时候进行强行匹配
     * @param avatar 用户头像地址
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 修改影响的行数
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar") String avatar,
                              @Param("modifiedUser") String modifiedUser,
                              @Param("modifiedTime") Date modifiedTime);
}
