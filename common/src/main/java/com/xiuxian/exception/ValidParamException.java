package com.xiuxian.exception;

/**
 * @author zhy
 * @date 2022/6/14 0:02
 * @description ValidParamException
 */
public class ValidParamException extends RuntimeException{

    private ExceptionEnum error;

    /**
     * 构造器，有时我们需要将第三方异常转为自定义异常抛出，但又不想丢失原来的异常信息，此时可以传入cause
     *
     * @param error
     * @param cause
     */
    public ValidParamException(ExceptionEnum error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    /**
     * 构造器，只传入错误枚举
     *
     * @param error
     */
    public ValidParamException(ExceptionEnum error) {
        this.error = error;
    }
}
