package com.jetco.demo.exception;

/**
 * @author liuhongwei
 * @date 2019-12-21
 * @description
 */
public abstract class AbstractException extends RuntimeException {

    protected final int code;

    public AbstractException(String message, int code) {
        super(message != null && message.trim().length() != 0 ? message : "错误");
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
