package com.jetco.demo.exception;

/**
 * @author liuhongwei
 * @date 2019-12-21
 * @description
 */
public class NotFoundException extends AbstractException {

    public NotFoundException(String message) {
        super(message, 999);
    }

    public NotFoundException() {
        super("未找到相应的资源", 999);
    }
}
