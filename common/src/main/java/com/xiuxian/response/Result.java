package com.xiuxian.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiuxian.log.TraceIdContext;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhy
 * @date 2022/6/13 22:51
 * @description Result
 */
@Data
@Accessors(chain = true)
public final class Result<T> {
    private Boolean success;
    private Integer code;
    private String msg;
    private String responseId;
    private T data;

    public static <T> Result<T> ofSuccess(T data) {
        return new Result<T>().setSuccess(true).setCode(200).setMsg("成功").setData(data).setResponseId(TraceIdContext.getTraceId());
    }

    public static Result<Void> ofFailure(Integer errCode, String errorMsg) {
        return new Result<Void>().setSuccess(false).setCode(errCode).setMsg(errorMsg).setResponseId(TraceIdContext.getTraceId());
    }

    public static void main(String[] args) {
        Result<String> stringResult = ofSuccess("测试一哈~");
        Result<Void> voidResult = ofFailure(1000, "失败了~");
        System.out.println("=== ：" + JSON.toJSONString(voidResult));
    }

}
