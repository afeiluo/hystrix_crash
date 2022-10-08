package com.afeiluo.crash.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {

    @Resource
    private DemoClient demoClient;

    @GetMapping("/origin")
    public Response<String> origin() throws Exception {
        String data = "";
        org.springframework.core.io.Resource resource = new ClassPathResource("smls.txt");
        InputStream inputStream = resource.getInputStream();
        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            data = new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException e) {
        }
        return Response.success(data);
    }

    @GetMapping("/feign")
    public Response<String> feign() {
        Response<String> resp = demoClient.request();
        return resp;
    }
}