package com.afeiluo.crash.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demoClient", url = "http://localhost:8888", fallbackFactory = DemoClientClientFallback.class)
public interface DemoClient {

    @GetMapping("/origin")
    Response<String> request();

}