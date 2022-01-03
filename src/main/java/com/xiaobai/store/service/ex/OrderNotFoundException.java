package com.xiaobai.store.service.ex;

/**
 * 订单未找到的异常
 * @author xiaobaicai
 * data:2022-01-02
 */

public class OrderNotFoundException extends ServiceException{
    public OrderNotFoundException() {
        super();
    }

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderNotFoundException(Throwable cause) {
        super(cause);
    }

    protected OrderNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
