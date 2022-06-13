package com.xiuxian.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhy
 * @date 2022/6/14 0:05
 * @description ExceptionEnum
 */
@Getter
public enum ExceptionEnum {


    ERROR_PARAM(10000, "参数错误");
    private final Integer code;
    private final String desc;

    ExceptionEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static final Map<Integer, ExceptionEnum> map = new HashMap<>();

    static {
        for (ExceptionEnum exceptionEnum : ExceptionEnum.values()) {
            map.put(exceptionEnum.getCode(), exceptionEnum);
        }
    }

    public String getDescByCode(Integer code) {
        return Optional.ofNullable(map.get(code))
                .map(ExceptionEnum::getDesc)
                .orElseThrow(() -> new IllegalArgumentException("invalid exception code!"));
    }


}
