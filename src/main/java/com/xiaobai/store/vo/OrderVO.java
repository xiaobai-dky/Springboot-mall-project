package com.xiaobai.store.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 订单列表多表联查的实体类
 * @author xiaobaicai
 * data:2022-01-02
 */
public class OrderVO implements Serializable {
    /**
     * 订单号
     */
    private Integer oid;
    /**
     * 订单的时间
     */
    private Date date;
    /**
     * 订单总价格
     */
    private Long totalPrice;
    /**
     * 收货人
     */
    private String recvName;
    /**
     * 商品的图片位置
     */
    private String image;
    /**
     * 商品id
     */
    private Integer pid;
    /**
     * 商品价格
     */
    private Long price;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 商品信息
     */
    private String title;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderVO)) {
            return false;
        }
        OrderVO orderVO = (OrderVO) o;
        return Objects.equals(getOid(), orderVO.getOid()) && Objects.equals(getDate(), orderVO.getDate()) && Objects.equals(getTotalPrice(), orderVO.getTotalPrice()) && Objects.equals(getRecvName(), orderVO.getRecvName()) && Objects.equals(getImage(), orderVO.getImage()) && Objects.equals(getPid(), orderVO.getPid()) && Objects.equals(getPrice(), orderVO.getPrice()) && Objects.equals(getNum(), orderVO.getNum()) && Objects.equals(getTitle(), orderVO.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOid(), getDate(), getTotalPrice(), getRecvName(), getImage(), getPid(), getPrice(), getNum(), getTitle());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderVO.class.getSimpleName() + "[", "]")
                .add("oid=" + oid)
                .add("date=" + date)
                .add("totalPrice=" + totalPrice)
                .add("recvName='" + recvName + "'")
                .add("image='" + image + "'")
                .add("pid=" + pid)
                .add("price=" + price)
                .add("num=" + num)
                .add("title='" + title + "'")
                .toString();
    }
}
