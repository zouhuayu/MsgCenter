package com.xiuxian.log;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * @author zhy
 * @date 2022/6/14 1:46
 * @description TraceIdContext
 */
@Slf4j
public class TraceIdContext {
    public static final String TRACE_ID_KEY = "log_trace_id";

    public static void setTraceId(String traceId) {
        if (StringUtils.isNotEmpty(traceId)) {
            MDC.put(TRACE_ID_KEY, traceId);
        }
    }

    public static String getTraceId() {
        String traceId = MDC.get(TRACE_ID_KEY);
        return traceId == null ? "" : traceId;
    }

    public static void removeTraceId() {
        MDC.remove(TRACE_ID_KEY);
    }
}
