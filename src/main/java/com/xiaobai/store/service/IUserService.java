package com.xiaobai.store.service;

import com.xiaobai.store.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户模块业务层接口
 * @author xiaobaicai
 * data:2021-12-31
 */

public interface IUserService {

    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     * 页面展示依赖于登录成功的信息，将用户User信息保存在session中
     * @param username 用户提交的username
     * @param password 用户提交的password
     * @return 返回User对象，便于在页面展示个人信息
     */
    User login(String username, String password);

    /**
     * 修改用户的密码
     * @param uid 用户的uid
     * @param username 用户名
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * 根据用户的id查询用户的数据
     * @param uid 用户的uid
     * @return 返回该用户对象
     */
    User getByUid(Integer uid);

    /**
     * 更新用户的数据操作
     * @param uid 用户的uid
     * @param username 用户名
     * @param user 用户对象
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * 修改用户头像
     * @param uid 用户的uid
     * @param avatar 用户头像存储的地址
     * @param username 修改者的名称
     */
    void changeAvatar(Integer uid, String avatar, String username);
}
