package com.xiaobai.store.service.impl;

import com.xiaobai.store.entity.User;
import com.xiaobai.store.mapper.UserMapper;
import com.xiaobai.store.service.IUserService;
import com.xiaobai.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 用户模块业务层的实现类 @Service不能少，将该实现类交给SpringBoot管理
 * @author xiaobaicai
 * data:2021-12-31
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    @Override
    public void reg(User user) {
        //通过user参数获取user的name
        String userName = user.getUsername();
        //调用mapper的findByUserName判断用户的名字是否被占用
        User result = userMapper.findByUsername(userName);
        //判断result是否为null，如果是null，可以注册，如果不为null，抛出名字被占用异常
        if (result != null) {
            throw new UsernameDepulitedException("用户名已被占用!");
        }
        /*
            对密码进行加密: MD5算法 串+password+串 --> md5算法加密 串被称为盐值
            盐值是一个随机的串（盐值 + password + 盐值）连续加密三次
         */
        String oldPassWord = user.getPassword();
        //获取一个随机的盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //加密

        String md5PassWord = getMD5PassWord(oldPassWord, salt);
        user.setPassword(md5PassWord);
        user.setSalt(salt);

        /*
            补全数据: 1.is_delete设置成0
                     2.4个日志字段信息
         */
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //执行注册业务功能的实现
        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("注册过程产生了未知的异常!");
        }
    }

    /**
     * 页面展示依赖于登录成功的信息
     * @param username 用户提交的username
     * @param password 用户提交的password
     * @return 返回User对象，便于在页面展示个人信息
     */
    @Override
    public User login(String username, String password) {
        //根据用户名来查询用户数据是否存在，如果不存在就抛出用户未找到异常
        User result = userMapper.findByUsername(username);

        //先判断用户数据是否存在，再判断is_delete字段的值是否为1，如果等于1就表示已经被标记为删除，
        if (result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("该用户数据不存在!");
        }
        //检测用户的密码是否匹配
        String salt = result.getSalt();
        String oldPassword = result.getPassword();
        String newMD5Password = getMD5PassWord(password, salt);
        if (!newMD5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("用户密码错误!");
        }
        //返回的数据是为了辅助其他页面做数据展示使用，只需要(uid,用户名username，用户头像avatar),提升了系统性能
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    /**
     * 修改用户的密码
     * @param uid         用户的uid
     * @param username    用户名
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("该用户数据不存在!");
        }
        //原密码与数据库中密码进行比较
        String oldMD5Password = getMD5PassWord(oldPassword, result.getSalt());
        if (!oldMD5Password.equals(result.getPassword())){
            throw new PasswordNotMatchException("用户密码错误!");
        }

        //修改密码
        String newMD5Password = getMD5PassWord(newPassword, result.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newMD5Password, username, new Date());
        if (rows != 1){
            throw new UpdateException("更新数据时产生的异常!");
        }


    }

    /**
     * 根据用户的id查询用户的数据
     * @param uid 用户的uid
     * @return 返回该用户对象
     */
    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在!");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    /**
     * 更新用户的数据操作
     * @param uid      用户的uid
     * @param username 用户名
     * @param user     用户对象
     */
    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在!");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1){
            throw new UpdateException("更新数据时产生了未知异常");
        }
    }

    /**
     * 修改用户头像
     * @param uid          用户的uid
     * @param avatar       用户头像存储的地址
     * @param username     修改者的名称
     */
    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete().equals(1)){
            throw new UserNotFoundException("用户数据不存在!");
        }
        Integer rows = userMapper.updateAvatarByUid(uid,avatar,username,new Date());
        if (rows != 1){
            throw new UpdateException("更新用户头像产生的未知异常!");
        }
    }

    /**
     * 对用户密码进行MD5加密
     * @param passWord 传入用户的密码
     * @param salt 传入一个盐值
     * @return 返回用户密码加密后的值
     */
    private String getMD5PassWord(String passWord, String salt){
        //MD5方法调用,进行三次加密
        for (int i = 0; i < 3; i++) {
            passWord = DigestUtils.md5DigestAsHex((salt+passWord+salt).getBytes()).toUpperCase();
        }
        return passWord;
    }
}
