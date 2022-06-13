package com.xiuxian.web.controller;

import com.xiuxian.exception.ExceptionEnum;
import com.xiuxian.exception.ValidParamException;
import com.xiuxian.response.Result;
import com.xiuxian.web.request.BaseReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendController {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/send")
    public Result<String> send(@RequestBody BaseReq baseReq) {

        if (StringUtils.isBlank(baseReq.getUserName())) {
            throw new ValidParamException(ExceptionEnum.ERROR_PARAM);
        }

        // 操作Redis中的string类型的数据,先获取ValueOperation
        ValueOperations valueOperations = redisTemplate.opsForValue();

        // 添加数据到redis
        valueOperations.set("msgName", "xxxx");


        return Result.ofSuccess("信息发送成功" + valueOperations.get("msgName"));
    }

}
