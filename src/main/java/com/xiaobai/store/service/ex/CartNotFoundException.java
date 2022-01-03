package com.xiaobai.store.service.ex;

/**
 * Cart未找到异常
 * @author xiaobaicai
 * data:2021-12-31
 */

public class CartNotFoundException extends ServiceException{
    public CartNotFoundException() {
        super();
    }

    public CartNotFoundException(String message) {
        super(message);
    }

    public CartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CartNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
