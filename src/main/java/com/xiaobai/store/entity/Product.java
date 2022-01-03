package com.xiaobai.store.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 商品信息实体类
 * @author xiaobaicai
 * data:2021-12-31
 */

public class Product extends BaseEntity implements Serializable {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 类型id
     */
    private Integer categoryId;
    /**
     * 物品型号
     */
    private String itemType;
    /**
     * 物品的标题
     */
    private String title;
    /**
     * 卖点
     */
    private String sellPoint;
    /**
     * 价格
     */
    private Long price;
    /**
     * 库存数量
     */
    private Integer num;
    /**
     * 图片
     */
    private String image;
    /**
     * 状态，比如热销还是下架，上架
     */
    private Integer status;
    /**
     * 优先级
     */
    private Integer priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getCategoryId(), product.getCategoryId()) && Objects.equals(getItemType(), product.getItemType()) && Objects.equals(getTitle(), product.getTitle()) && Objects.equals(getSellPoint(), product.getSellPoint()) && Objects.equals(getPrice(), product.getPrice()) && Objects.equals(getNum(), product.getNum()) && Objects.equals(getImage(), product.getImage()) && Objects.equals(getStatus(), product.getStatus()) && Objects.equals(getPriority(), product.getPriority());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getCategoryId(), getItemType(), getTitle(), getSellPoint(), getPrice(), getNum(), getImage(), getStatus(), getPriority());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", itemType='" + itemType + '\'' +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
