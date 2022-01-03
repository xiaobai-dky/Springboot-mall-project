package com.xiaobai.store.service.ex;

/**
 * 用户名字异常类
 * @author xiaobaicai
 * data:2021-12-31
 */

public class UsernameDepulitedException extends ServiceException {
    public UsernameDepulitedException() {
        super();
    }

    public UsernameDepulitedException(String message) {
        super(message);
    }

    public UsernameDepulitedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDepulitedException(Throwable cause) {
        super(cause);
    }

    protected UsernameDepulitedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
