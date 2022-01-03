package com.xiaobai.store.entity;

import java.util.Objects;

/**
 * 省市区实体类
 * @author PC
 */
public class District extends BaseEntity{
    /**
     * 省市区的id
     */
    private Integer id;
    /**
     * 上一级的代号，比如110101是北京东城区，上一级代号110100代表北京市
     */
    private String parent;
    /**
     * 自己的代号，比如110101是北京东城区
     */
    private String code;
    /**
     * 地区的名称比如东城区
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof District)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        District district = (District) o;
        return Objects.equals(getId(), district.getId()) && Objects.equals(getParent(), district.getParent()) && Objects.equals(getCode(), district.getCode()) && Objects.equals(getName(), district.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getParent(), getCode(), getName());
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
