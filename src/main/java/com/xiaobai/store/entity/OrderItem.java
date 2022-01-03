package com.xiaobai.store.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 订单列表详细实体类
 * @author xiaobaicai
 * data:2021-12-31
 */

public class OrderItem extends BaseEntity implements Serializable {
    /**
     * 订单列表id
     */
    private Integer id;
    /**
     * 订单id
     */
    private Integer oid;
    /**
     * 商品id
     */
    private Integer pid;
    /**
     * 订单中商品介绍的标题
     */
    private String title;
    /**
     * 图片地址
     */
    private String image;
    /**
     * 价格
     */
    private Long price;
    /**
     * 商品的数量
     */
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(o instanceof OrderItem)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) && Objects.equals(oid, orderItem.oid) && Objects.equals(pid, orderItem.pid) && Objects.equals(title, orderItem.title) && Objects.equals(image, orderItem.image) && Objects.equals(price, orderItem.price) && Objects.equals(num, orderItem.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, oid, pid, title, image, price, num);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oid=" + oid +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
