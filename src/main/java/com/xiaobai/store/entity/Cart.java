package com.xiaobai.store.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 购物车的实体类
 * @author xiaobaicai
 * data:2021-12-31
 */

public class Cart extends BaseEntity implements Serializable {
    /**
     * 购物车的id
     */
    private Integer cid;
    /**
     * 购物车属于用户的uid
     */
    private Integer uid;
    /**
     * 购物车中商品的pid
     */
    private Integer pid;
    /**
     * 对应商品的价格
     */
    private Long price;
    /**
     * 商品的数量
     */
    private Integer num;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cart)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Cart cart = (Cart) o;
        return Objects.equals(getCid(), cart.getCid()) && Objects.equals(getUid(), cart.getUid()) && Objects.equals(getPid(), cart.getPid()) && Objects.equals(getPrice(), cart.getPrice()) && Objects.equals(getNum(), cart.getNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCid(), getUid(), getPid(), getPrice(), getNum());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
