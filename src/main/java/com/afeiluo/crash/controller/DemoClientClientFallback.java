package com.afeiluo.crash.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoClientClientFallback implements FallbackFactory<DemoClient> {

    @Override
    public DemoClient create(Throwable cause) {
        return new DemoClient() {
            @Override
            public Response<String> request() {
                log.error("call demo request fallback! {}", getStackTrace(cause));
                return null;
            }
        };
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
