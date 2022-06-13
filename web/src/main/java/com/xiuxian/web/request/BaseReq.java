package com.xiuxian.web.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhy
 * @date 2022/6/14 0:23
 * @description BaseReq
 */
@Data
public class BaseReq implements Serializable {
    private String userName;
}
