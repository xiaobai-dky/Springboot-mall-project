package com.xiaobai.store.util;

import java.io.Serializable;

/**
 * json格式的数据进行响应，声明泛型<E>
 * @author xiaobaicai
 * data:2021-12-31
 */

public class JsonResult<E> implements Serializable {
    /** 状态码 */
    private Integer state;
    /** 描述信息 */
    private String message;
    /** 数据类型不确定要用泛型E */
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
