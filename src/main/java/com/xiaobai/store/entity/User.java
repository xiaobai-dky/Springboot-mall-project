package com.xiaobai.store.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用户的实体类
 * @author xiaobaicai
 * data:2021-12-31
 */

public class User extends BaseEntity implements Serializable {
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     *电话
     */
    private String phone;
    /**
     *邮箱
     */
    private String email;
    /**
     *性别 0代表女性，1代表男性
     */
    private Integer gender;
    /**
     *用户头像
     */
    private String avatar;
    /**
     *是否注销
     */
    private Integer isDelete;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getUid(), user.getUid()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getSalt(), user.getSalt()) && Objects.equals(getPhone(), user.getPhone()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getGender(), user.getGender()) && Objects.equals(getAvatar(), user.getAvatar()) && Objects.equals(getIsDelete(), user.getIsDelete());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUid(), getUsername(), getPassword(), getSalt(), getPhone(), getEmail(), getGender(), getAvatar(), getIsDelete());
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
