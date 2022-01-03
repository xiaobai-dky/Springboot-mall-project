package com.xiaobai.store.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 购物车数据多表联查的VO类
 * @author xiaobaicai
 * data:2021-12-31
 */

public class CartVO implements Serializable {
    /**
     * 购物车号
     */
    private Integer cid;
    /**
     * 用户id
     */
    private Integer uid;
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
    /**
     * 商品真实价格
     */
    private Long realPrice;
    /**
     * 图片的位置
     */
    private String image;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CartVO)) {
            return false;
        }
        CartVO cartVO = (CartVO) o;
        return Objects.equals(cid, cartVO.cid) && Objects.equals(uid, cartVO.uid) && Objects.equals(pid, cartVO.pid) && Objects.equals(price, cartVO.price) && Objects.equals(num, cartVO.num) && Objects.equals(title, cartVO.title) && Objects.equals(realPrice, cartVO.realPrice) && Objects.equals(image, cartVO.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, uid, pid, price, num, title, realPrice, image);
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", realPrice=" + realPrice +
                ", image='" + image + '\'' +
                '}';
    }
}
