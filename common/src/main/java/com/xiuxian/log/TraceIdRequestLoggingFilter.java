package com.xiuxian.log;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author zhy
 * @date 2022/6/14 1:45
 * @description TraceIdRequestLoggingFilter
 */
@Slf4j
@Component
public class TraceIdRequestLoggingFilter  extends AbstractRequestLoggingFilter {
    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        String traceId = request.getHeader(TraceIdContext.TRACE_ID_KEY);
        if (StringUtils.isNotEmpty(traceId)) {
            TraceIdContext.setTraceId(traceId);
        } else {
            TraceIdContext.setTraceId(UUID.randomUUID().toString());
        }
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        TraceIdContext.removeTraceId();
    }
}
