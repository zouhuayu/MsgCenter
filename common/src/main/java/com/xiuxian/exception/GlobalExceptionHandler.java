package com.xiuxian.exception;

import com.xiuxian.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhy
 * @date 2022/6/13 23:54
 * @description GlobalExceptionHandler
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ValidParamException.class)
    public Result validParamExceptionHandler(ValidParamException validParamException){
        log.error("参数校验异常:{}", validParamException.getMessage(), validParamException);
        return Result.ofFailure(1000, "失败~");
    }
}
