package com.xiaobai.store.service.ex;

/**
 * 地址重复创建的异常
 * @author xiaobaicai
 * data:2021-12-31
 */

public class AccessDeniedException extends ServiceException{
    public AccessDeniedException() {
        super();
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    protected AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
