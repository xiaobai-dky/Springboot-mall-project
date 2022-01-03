package com.xiaobai.store.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

/**
 * 订单数据的实体类
 * @author xiaobaicai
 * data:2021-12-31
 */

public class Order extends BaseEntity implements Serializable {
    /**
     * 订单id
     */
    private Integer oid;
    /**
     * 订单所属用户id
     */
    private Integer uid;
    /**
     * 收货人的名称
     */
    private String recvName;
    /**
     * 收货人的号码
     */
    private String recvPhone;
    /**
     * 收货人的省(直辖市)
     */
    private String recvProvince;
    /**
     * 收货人的市(直辖市)
     */
    private String recvCity;
    /**
     * 收货人的区(县)
     */
    private String recvArea;
    /**
     * 具体地址
     */
    private String recvAddress;
    /**
     * 订单总价格
     */
    private Long totalPrice;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 订单时间
     */
    private Date orderTime;
    /**
     * 支付时间
     */
    private Date payTime;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }

    public String getRecvProvince() {
        return recvProvince;
    }

    public void setRecvProvince(String recvProvince) {
        this.recvProvince = recvProvince;
    }

    public String getRecvCity() {
        return recvCity;
    }

    public void setRecvCity(String recvCity) {
        this.recvCity = recvCity;
    }

    public String getRecvArea() {
        return recvArea;
    }

    public void setRecvArea(String recvArea) {
        this.recvArea = recvArea;
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Order order = (Order) o;

        if (getOid() != null ? !getOid().equals(order.getOid()) : order.getOid() != null) {
            return false;
        }
        if (getUid() != null ? !getUid().equals(order.getUid()) : order.getUid() != null) {
            return false;
        }
        if (getRecvName() != null ? !getRecvName().equals(order.getRecvName()) : order.getRecvName() != null) {
            return false;
        }
        if (getRecvPhone() != null ? !getRecvPhone().equals(order.getRecvPhone()) : order.getRecvPhone() != null) {
            return false;
        }
        if (getRecvProvince() != null ? !getRecvProvince().equals(order.getRecvProvince()) : order.getRecvProvince() != null) {
            return false;
        }
        if (getRecvCity() != null ? !getRecvCity().equals(order.getRecvCity()) : order.getRecvCity() != null) {
            return false;
        }
        if (getRecvArea() != null ? !getRecvArea().equals(order.getRecvArea()) : order.getRecvArea() != null) {
            return false;
        }
        if (getRecvAddress() != null ? !getRecvAddress().equals(order.getRecvAddress()) : order.getRecvAddress() != null) {
            return false;
        }
        if (getTotalPrice() != null ? !getTotalPrice().equals(order.getTotalPrice()) : order.getTotalPrice() != null) {
            return false;
        }
        if (getStatus() != null ? !getStatus().equals(order.getStatus()) : order.getStatus() != null) {
            return false;
        }
        if (getOrderTime() != null ? !getOrderTime().equals(order.getOrderTime()) : order.getOrderTime() != null) {
            return false;
        }
        return getPayTime() != null ? getPayTime().equals(order.getPayTime()) : order.getPayTime() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getOid() != null ? getOid().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getRecvName() != null ? getRecvName().hashCode() : 0);
        result = 31 * result + (getRecvPhone() != null ? getRecvPhone().hashCode() : 0);
        result = 31 * result + (getRecvProvince() != null ? getRecvProvince().hashCode() : 0);
        result = 31 * result + (getRecvCity() != null ? getRecvCity().hashCode() : 0);
        result = 31 * result + (getRecvArea() != null ? getRecvArea().hashCode() : 0);
        result = 31 * result + (getRecvAddress() != null ? getRecvAddress().hashCode() : 0);
        result = 31 * result + (getTotalPrice() != null ? getTotalPrice().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getOrderTime() != null ? getOrderTime().hashCode() : 0);
        result = 31 * result + (getPayTime() != null ? getPayTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("oid=" + oid)
                .add("uid=" + uid)
                .add("recvName='" + recvName + "'")
                .add("recvPhone='" + recvPhone + "'")
                .add("recvProvince='" + recvProvince + "'")
                .add("recvCity='" + recvCity + "'")
                .add("recvArea='" + recvArea + "'")
                .add("recvAddress='" + recvAddress + "'")
                .add("totalPrice=" + totalPrice)
                .add("status=" + status)
                .add("orderTime=" + sdf.format(orderTime))
                .add("payTime=" + payTime)
                .toString();
    }
}
