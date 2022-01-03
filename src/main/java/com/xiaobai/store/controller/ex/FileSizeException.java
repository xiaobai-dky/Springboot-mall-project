package com.xiaobai.store.controller.ex;

/**
 * 文件大小超出异常
 * @author xiaobaicai
 * data:2021-12-31
 */

public class FileSizeException extends FileUploadException{
    public FileSizeException() {
        super();
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
