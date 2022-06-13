package com.xiuxian.web.controller;

import com.xiuxian.exception.ExceptionEnum;
import com.xiuxian.exception.ValidParamException;
import com.xiuxian.response.Result;
import com.xiuxian.web.request.BaseReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @RequestMapping("/send")
    public Result<String> send(@RequestBody BaseReq baseReq) {

        if (StringUtils.isBlank(baseReq.getUserName())) {
            throw new ValidParamException(ExceptionEnum.ERROR_PARAM);
        }
        return Result.ofSuccess("信息发送成功");
    }

}
